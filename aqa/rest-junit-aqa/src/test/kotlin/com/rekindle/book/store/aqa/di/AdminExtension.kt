package com.rekindle.book.store.aqa.di

import com.google.inject.Guice
import com.google.inject.Injector
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.ParameterContext
import org.junit.jupiter.api.extension.ParameterResolver

class AdminExtension : ParameterResolver {
    private val injector: Injector = Guice.createInjector(AdminModule())

    override fun supportsParameter(p0: ParameterContext?, p1: ExtensionContext?): Boolean {
        return injector.getBinding(p0!!.parameter.type) != null
    }

    override fun resolveParameter(p0: ParameterContext?, p1: ExtensionContext?): Any {
        return injector.getInstance(p0!!.parameter.getType());
    }
}