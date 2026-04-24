package edu.monash.fit5046.healthyrecipehub.data.remote.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

/**
 * Email API Service
 * For Email Center functionality
 */
interface EmailApiService {

    @POST("/api/email/send")
    suspend fun sendEmail(
        @Header("Authorization") token: String,
        @Body request: EmailSendRequest
    ): Response<EmailSendResponse>

    @POST("/api/email/bulk")
    suspend fun sendBulkEmail(
        @Header("Authorization") token: String,
        @Body request: BulkEmailRequest
    ): Response<EmailSendResponse>

    @POST("/api/email/templates")
    suspend fun getEmailTemplates(
        @Header("Authorization") token: String
    ): Response<EmailTemplatesResponse>

    @POST("/api/email/contact")
    suspend fun sendContactForm(
        @Body request: ContactFormRequest
    ): Response<EmailSendResponse>
}

data class EmailSendRequest(
    val to: String,
    val toName: String? = null,
    val subject: String,
    val body: String,
    val isHtml: Boolean = false
)

data class BulkEmailRequest(
    val recipients: List<EmailRecipient>,
    val subject: String,
    val body: String,
    val isHtml: Boolean = false
)

data class EmailRecipient(
    val email: String,
    val name: String? = null
)

data class ContactFormRequest(
    val name: String,
    val email: String,
    val subject: String,
    val message: String
)

data class EmailSendResponse(
    val success: Boolean,
    val messageId: String? = null,
    val message: String? = null
)

data class EmailTemplatesResponse(
    val templates: List<EmailTemplateDto>
)

data class EmailTemplateDto(
    val id: String,
    val name: String,
    val subject: String,
    val body: String,
    val isHtml: Boolean
)
