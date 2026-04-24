package edu.monash.fit5046.healthyrecipehub.data.remote.api;

/**
 * Email API Service
 * For Email Center functionality
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J(\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\n\u001a\u00020\u000eH\u00a7@\u00a2\u0006\u0002\u0010\u000fJ(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u0011H\u00a7@\u00a2\u0006\u0002\u0010\u0012\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0013\u00c0\u0006\u0001"}, d2 = {"Ledu/monash/fit5046/healthyrecipehub/data/remote/api/EmailApiService;", "", "getEmailTemplates", "Lretrofit2/Response;", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/EmailTemplatesResponse;", "token", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendBulkEmail", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/EmailSendResponse;", "request", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/BulkEmailRequest;", "(Ljava/lang/String;Ledu/monash/fit5046/healthyrecipehub/data/remote/api/BulkEmailRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendContactForm", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/ContactFormRequest;", "(Ledu/monash/fit5046/healthyrecipehub/data/remote/api/ContactFormRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendEmail", "Ledu/monash/fit5046/healthyrecipehub/data/remote/api/EmailSendRequest;", "(Ljava/lang/String;Ledu/monash/fit5046/healthyrecipehub/data/remote/api/EmailSendRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface EmailApiService {
    
    @retrofit2.http.POST(value = "/api/email/send")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object sendEmail(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.remote.api.EmailSendRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<edu.monash.fit5046.healthyrecipehub.data.remote.api.EmailSendResponse>> $completion);
    
    @retrofit2.http.POST(value = "/api/email/bulk")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object sendBulkEmail(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.remote.api.BulkEmailRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<edu.monash.fit5046.healthyrecipehub.data.remote.api.EmailSendResponse>> $completion);
    
    @retrofit2.http.POST(value = "/api/email/templates")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getEmailTemplates(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<edu.monash.fit5046.healthyrecipehub.data.remote.api.EmailTemplatesResponse>> $completion);
    
    @retrofit2.http.POST(value = "/api/email/contact")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object sendContactForm(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    edu.monash.fit5046.healthyrecipehub.data.remote.api.ContactFormRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<edu.monash.fit5046.healthyrecipehub.data.remote.api.EmailSendResponse>> $completion);
}