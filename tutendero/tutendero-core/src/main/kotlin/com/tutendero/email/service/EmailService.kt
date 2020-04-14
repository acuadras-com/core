package com.tutendero.email.service

import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service


interface EmailService{
    fun sendEmail(to:String,subject:String,text:String)
}

@Service
class EmailServiceImpl(private val emailSender: JavaMailSender): EmailService {
    override fun sendEmail(to: String, subject: String, text: String) {
        if(to.trim().isEmpty() || subject.trim().isEmpty() || text.trim().isEmpty())
        {
            throw EmailException("some of the mandatory inputs is empty")
        }
        val message = SimpleMailMessage()
        message.setTo(to)
        message.setSubject(subject)
        message.setText(text)
        emailSender.send(message)
    }
}