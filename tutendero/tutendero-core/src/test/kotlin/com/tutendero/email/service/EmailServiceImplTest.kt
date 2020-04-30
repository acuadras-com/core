package com.tutendero.email.service

import com.tutendero.email.config.MailProcessor
import com.tutendero.email.service.impl.EmailServiceImpl
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.thymeleaf.spring5.SpringTemplateEngine

internal class EmailServiceImplTest{


    private val emailServiceImpl=
            EmailServiceImpl(
                    MailProcessor().getJavaMailSender(),
                    SpringTemplateEngine()
    )

    @Test
    fun  `empty mandatory input`(){
        assertThrows<EmailException> {
            emailServiceImpl.sendSimpleEmail("","","")
        }
    }
}