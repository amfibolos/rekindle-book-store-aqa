package com.rekindle.book.store.domain.factory

import com.google.inject.ImplementedBy
import com.rekindle.book.store.domain.valueobjects.ValueObject
interface FactoryKit {
    fun <T : ValueObject> factory(key: ValueKey): Factory<T>
}