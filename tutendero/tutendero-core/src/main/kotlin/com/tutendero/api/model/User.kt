package com.tutendero.api.model

import com.tutendero.api.model.interfaces.AuditableEntity
import com.tutendero.api.model.interfaces.DisableableEntity
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*
import java.util.stream.Collectors

@Document
data class User(
        var name: String,
        private var username: String,
        private var password: String,
        var roles: List<String>
) : UserDetails, DisableableEntity, AuditableEntity {
    @Id
    var id: String? = null
    var phone: String? = null

    @Field("customer_id")
    var customerId: String? = null

    @Field("shops_ids")
    var shopsIds: List<String?> = mutableListOf<String>()
    var acceptedTermsAndConditionsAt: Date? = null
    var termsAndConditionsVersion: String? = null
    var token: String? = null

    override var disabled = false
    override var createdAt: Date = Date()
    override var updatedAt: Date? = null

    override fun getAuthorities(): Collection<GrantedAuthority?> {
        return roles.stream().map { role: String? -> SimpleGrantedAuthority(role) }.collect(Collectors.toList())
    }

    override fun getPassword(): String {
        return password
    }

    fun updatePassword(password: String) {
        this.password = password
    }

    override fun getUsername(): String {
        return username
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return !disabled
    }
}

data class UserDto(
        var name: String,
        var username: String,
        var password: String,
        var roles: List<String>
)

fun UserDto.toEntity(): User {
    return User(this.name, this.username, this.password, this.roles)
}

fun User.toDto(): UserDto {
    return UserDto(this.name, this.username, "", this.roles
    )
}