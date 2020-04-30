package com.tutendero.email.service

import com.tutendero.email.model.Mail


interface EmailService {
    fun sendSimpleEmail(to: String, subject: String, text: String)
    fun sendTemplateEmail(mail: Mail, template: String)
}
