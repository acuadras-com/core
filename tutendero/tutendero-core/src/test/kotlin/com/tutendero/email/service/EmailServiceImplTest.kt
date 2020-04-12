package com.tutendero.email.service

import com.tutendero.email.config.MailProcessor
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class EmailServiceImplTest{


    private val emailServiceImpl= EmailServiceImpl(MailProcessor().getJavaMailSender())

    @Test
    fun  `empty mandatory input`(){
        assertThrows<EmailException> {
            emailServiceImpl.sendEmail("","","")
        }
    }
}