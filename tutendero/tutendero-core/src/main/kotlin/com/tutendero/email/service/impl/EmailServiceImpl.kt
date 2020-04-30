package com.tutendero.email.service.impl

import com.tutendero.email.model.Mail
import com.tutendero.email.service.EmailException
import com.tutendero.email.service.EmailService
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service
import org.thymeleaf.context.Context
import org.thymeleaf.spring5.SpringTemplateEngine
import java.io.IOException
import java.nio.charset.StandardCharsets
import javax.mail.MessagingException


@Service
class EmailServiceImpl(
        private val emailSender: JavaMailSender,
        private val templateEngine: SpringTemplateEngine
) : EmailService {

    override fun sendSimpleEmail(to: String, subject: String, text: String) {
        if (to.trim().isEmpty() || subject.trim().isEmpty() || text.trim().isEmpty()) {
            throw EmailException("some of the mandatory inputs is empty")
        }
        val message = SimpleMailMessage()
        message.setTo(to)
        message.setSubject(subject)
        message.setText(text)
        emailSender.send(message)
    }

    @Throws(MessagingException::class, IOException::class)
    override fun sendTemplateEmail(mail: Mail, template: String) {
        val message = emailSender.createMimeMessage()
        val helper = MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name())
        val context = Context()
        context.setVariables(mail.props)
        val html = templateEngine.process(template, context)
        helper.setTo(mail.to)
        helper.setText(html, true)
        helper.setSubject(mail.subject)
        emailSender.send(message)
    }
}