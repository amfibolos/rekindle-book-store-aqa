package com.rekindle.book.store.domain.filters

import com.fasterxml.jackson.databind.ser.FilterProvider
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider

class JacksonFilters {
    companion object {
        val idFilter: FilterProvider = SimpleFilterProvider().addFilter(
            Filter.ID_FILTER,
            SimpleBeanPropertyFilter.serializeAllExcept("id")
        )
    }
}