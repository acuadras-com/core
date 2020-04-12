package com.tutendero.api.config

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@Configuration
@PropertySource("file:/etc/tutendero/config/application.properties")
class PropertyConfiguration {

}