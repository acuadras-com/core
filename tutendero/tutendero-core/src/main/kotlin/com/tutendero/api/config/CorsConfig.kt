package com.tutendero.api.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.Ordered
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter


@Configuration
class CorsConfig {

    @Value("\${app.cors.allow}")
    lateinit var allowOrigin: String

    @Bean
    fun corsFilter(): FilterRegistrationBean<*>? {
        val source = UrlBasedCorsConfigurationSource()
        val configAutenticacao = CorsConfiguration()
        configAutenticacao.allowCredentials = true
        configAutenticacao.addAllowedOrigin(allowOrigin)
        configAutenticacao.addAllowedHeader("Authorization")
        configAutenticacao.addAllowedHeader("Content-Type")
        configAutenticacao.addAllowedHeader("Accept")
        configAutenticacao.addAllowedMethod("POST")
        configAutenticacao.addAllowedMethod("GET")
        configAutenticacao.addAllowedMethod("DELETE")
        configAutenticacao.addAllowedMethod("PUT")
        configAutenticacao.addAllowedMethod("OPTIONS")
        configAutenticacao.maxAge = 3600L
        source.registerCorsConfiguration("/**", configAutenticacao)
        // source.registerCorsConfiguration("/**", configAutenticacao); // Global for all paths
        val bean: FilterRegistrationBean<*> = FilterRegistrationBean(CorsFilter(source))
        bean.order = Ordered.HIGHEST_PRECEDENCE
        return bean
    }
}