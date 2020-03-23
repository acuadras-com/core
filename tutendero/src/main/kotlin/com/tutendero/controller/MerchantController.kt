package com.tutendero.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/merchant")
class MerchantController {

    @GetMapping("/")
    fun test(): String {
        return "Return all the merchants near"
    }
}