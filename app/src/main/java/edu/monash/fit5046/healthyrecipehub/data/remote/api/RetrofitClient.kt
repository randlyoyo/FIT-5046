package edu.monash.fit5046.healthyrecipehub.data.remote.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

/**
 * Retrofit Client Configuration
 * Singleton pattern for API client
 */
object RetrofitClient {

    // Base URL - Using dev mode for testing
    // For production: https://api.healthyrecipehub.com/
    private const val BASE_URL = "http://10.0.2.2:3000/" // For Android emulator local testing
    const val DEV_BASE_URL = "http://10.0.2.2:3000/"

    private val isDevMode = true // Set to false for production

    private var authToken: String? = null

    fun setAuthToken(token: String?) {
        authToken = token
    }

    /**
     * Logging interceptor for debugging
     */
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    /**
     * Auth interceptor to add token to requests
     */
    private val authInterceptor = Interceptor { chain ->
        val original = chain.request()
        val requestBuilder = original.newBuilder()

        authToken?.let {
            requestBuilder.header("Authorization", "Bearer $it")
        }

        requestBuilder.header("Accept", "application/json")
        requestBuilder.header("Content-Type", "application/json")

        val request = requestBuilder.build()
        chain.proceed(request)
    }

    /**
     * Unsafe trust manager for development (allows self-signed certificates)
     */
    private val unsafeTrustManager = object : X509TrustManager {
        override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {}
        override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {}
        override fun getAcceptedIssuers(): Array<X509Certificate> = arrayOf()
    }

    /**
     * Unsafe SSL context for development
     */
    private val unsafeSslContext: SSLContext by lazy {
        val trustAllCerts = arrayOf<TrustManager>(unsafeTrustManager)
        SSLContext.getInstance("SSL").apply {
            init(null, trustAllCerts, java.security.SecureRandom())
        }
    }

    /**
     * OkHttp Client configuration
     */
    private val okHttpClient: OkHttpClient by lazy {
        val builder = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(authInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)

        // Allow insecure connections in dev mode
        if (isDevMode) {
            builder.sslSocketFactory(unsafeSslContext.socketFactory, unsafeTrustManager)
            builder.hostnameVerifier { _, _ -> true }
        }

        builder.build()
    }

    /**
     * Retrofit instance
     */
    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    /**
     * API Service instances
     */
    val recipeApiService: RecipeApiService by lazy {
        retrofit.create(RecipeApiService::class.java)
    }

    val authApiService: AuthApiService by lazy {
        retrofit.create(AuthApiService::class.java)
    }

    val adminApiService: AdminApiService by lazy {
        retrofit.create(AdminApiService::class.java)
    }

    val emailApiService: EmailApiService by lazy {
        retrofit.create(EmailApiService::class.java)
    }

    val aiApiService: AIApiService by lazy {
        retrofit.create(AIApiService::class.java)
    }

    /**
     * Create development client (for local testing)
     */
    fun createDevClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(DEV_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

/**
 * API Response Handler
 */
suspend fun <T> safeApiCall(apiCall: suspend () -> retrofit2.Response<T>): edu.monash.fit5046.healthyrecipehub.data.model.Result<T> {
    return try {
        val response = apiCall()
        if (response.isSuccessful) {
            val body = response.body()
            if (body != null) {
                edu.monash.fit5046.healthyrecipehub.data.model.Result.Success(body)
            } else {
                edu.monash.fit5046.healthyrecipehub.data.model.Result.Error(
                    Exception("Response body is null"),
                    "Empty response from server"
                )
            }
        } else {
            val errorMsg = response.errorBody()?.string() ?: "Unknown error"
            edu.monash.fit5046.healthyrecipehub.data.model.Result.Error(
                Exception("API Error: ${response.code()}"),
                errorMsg
            )
        }
    } catch (e: Exception) {
        edu.monash.fit5046.healthyrecipehub.data.model.Result.Error(
            e,
            e.message ?: "Network error occurred"
        )
    }
}
