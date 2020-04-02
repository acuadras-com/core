package com.tutendero.api.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*
import java.util.stream.Collectors

@Document
class User(var type: String, var email: String, private var password: String, private var roles: Array<String>) : UserDetails {
    @Id
    @Field("_id")
    var id: ObjectId? = null
    val key: String
        get() = id.toString()
    var creationDate: Date = Date()
    var updateDate: Date? = null

    override fun getUsername(): String {
        return this.email;
    }

    override fun getPassword(): String {
        return this.password;
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> =
            ArrayList()//this.roles.map{ role: String? -> SimpleGrantedAuthority(role) }
            //roles.stream().map { role: String? -> SimpleGrantedAuthority(role) }.collect(Collectors.toList())

    override fun isEnabled(): Boolean {
        return true;
    }


    override fun isCredentialsNonExpired(): Boolean {
        return true;
    }

    override fun isAccountNonExpired(): Boolean {
        return true;
    }

    override fun isAccountNonLocked(): Boolean {
        return true;
    }
}