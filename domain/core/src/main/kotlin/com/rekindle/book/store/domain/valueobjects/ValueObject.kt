package com.rekindle.book.store.domain.valueobjects

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.ser.FilterProvider

interface ValueObject {
    fun toJsonString(): String {
        return ObjectMapper().writeValueAsString(this)
    }

    fun toJsonStringFiltered(filter: FilterProvider): String {
        return ObjectMapper().setFilterProvider(filter).writeValueAsString(this)
    }
}