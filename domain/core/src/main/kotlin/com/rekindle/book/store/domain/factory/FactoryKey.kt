package com.rekindle.book.store.domain.factory

enum class FactoryKey : ValueKey {
    CUSTOMER,
    BOOKSTORE;

    override fun getKey(): ValueKey {
        return this;
    }

}