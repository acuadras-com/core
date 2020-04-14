package com.tutendero

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
class TutenderoApplication

fun main(args: Array<String>) {
	runApplication<TutenderoApplication>(*args)
}