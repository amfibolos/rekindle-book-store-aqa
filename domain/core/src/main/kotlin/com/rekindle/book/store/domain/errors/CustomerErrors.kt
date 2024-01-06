package com.rekindle.book.store.domain.errors

object CustomerErrors {
    const val CUSTOMER_NOT_FOUND = "Customer not found!"
    const val CUSTOMER_USERNAME_NOT_NULL = "createCustomer.arg0.username must not be null"
    const val CUSTOMER_USERNAME_NOT_BLANK = "createCustomer.arg0.username must not be blank"
    const val CUSTOMER_FIRSTNAME_NOT_BLANK = "createCustomer.arg0.firstName must not be blank"
    const val CUSTOMER_FIRSTNAME_NOT_NULL = "createCustomer.arg0.firstName must not be null"
    const val CUSTOMER_LASTNAME_NOT_BLANK = "createCustomer.arg0.lastName must not be blank"
    const val CUSTOMER_LASTNAME_NOT_NULL = "createCustomer.arg0.lastName must not be null"
}