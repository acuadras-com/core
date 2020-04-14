package com.tutendero.api.model

fun CustomerDto.toEntity():Customer{
    val customer = Customer(this.demographics)
    customer.id=this.id
    customer.createdDate=this.createdDate
    customer.disabled=this.disabled
    customer.location=this.location
    return customer
}

fun Customer.toDto(){

}