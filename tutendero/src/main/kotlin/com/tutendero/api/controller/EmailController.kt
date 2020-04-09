package com.tutendero.api.controller

import com.tutendero.email.service.EmailService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid
import javax.validation.constraints.NotBlank


@RestController
@RequestMapping("/email")
class EmailController(
        private val emailService: EmailService
) {

    @PostMapping
    fun sendEmail(@RequestBody emailSendRequest: @Valid EmailSendRequest) {
        emailService
                .sendEmail(emailSendRequest.to, emailSendRequest.subject,
                        emailSendRequest.text)
    }
}

data class EmailSendRequest(
        val to: @NotBlank(message = "email to is required") String,
        val subject: @NotBlank(message = "subject is required") String,
        val text: @NotBlank(message = "text is required") String
)