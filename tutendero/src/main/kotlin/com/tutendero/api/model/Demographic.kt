package com.tutendero.api.model

import javax.validation.constraints.NotBlank

data class Demographic(
        var address: @NotBlank(message = "address is required") String? = null,
        var neighborhood: String? = null
)