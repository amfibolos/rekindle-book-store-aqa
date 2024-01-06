package com

import com.rekindle.book.store.domain.factory.Factory
import com.rekindle.book.store.domain.factory.FactoryKey
import com.rekindle.book.store.domain.factory.ValueObjectFactoryKit
import com.rekindle.book.store.domain.factory.customer.CustomerKey
import com.rekindle.book.store.domain.valueobjects.Customer

fun main() {

    val factoryKit = ValueObjectFactoryKit()
    val customerFactory : Factory<Customer> = factoryKit.factory(FactoryKey.CUSTOMER)
    val customer = customerFactory.create(CustomerKey.STD_USER)

}