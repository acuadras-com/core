package com.tutendero.email.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.mail.javamail.JavaMailSenderImpl
import java.util.Properties

@Configuration
class MailProcessor {

    @Bean
    fun getJavaMailSender() = with(JavaMailSenderImpl()) {
               this.host = "smtp.gmail.com"
               this.port = 587
               this.username = "tutendero.startup@gmail.com"
               this.password = "CambiandoElMundo"
               val props: Properties = this.javaMailProperties
               props.put("mail.transport.protocol", "smtp")
               props.put("mail.smtp.auth", "true")
               props.put("mail.smtp.starttls.enable", "true")
               props.put("mail.debug", "true")
               this
    }
}