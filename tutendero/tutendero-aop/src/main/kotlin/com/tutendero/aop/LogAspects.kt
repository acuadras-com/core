package com.tutendero.aop

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component


@Aspect
@Component
class LogAspects {

    private val log: Logger = LoggerFactory.getLogger(LogAspects::class.java)

    @Around("execution(* com.tutendero.api.controller..*(..))")
    fun logControllers(joinPoint: ProceedingJoinPoint): Any {
        val signature = joinPoint.signature.toShortString()
        val request = joinPoint.args.joinToString("/ ")
        log.info("starting $signature request:$request ")
        val result = joinPoint.proceed()
        log.info("finishing $signature result: $result")
        return result
    }
}