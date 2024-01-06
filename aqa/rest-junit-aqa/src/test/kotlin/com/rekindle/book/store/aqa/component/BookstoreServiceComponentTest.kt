package com.rekindle.book.store.aqa.component

import com.google.inject.Inject
import com.rekindle.book.store.aqa.di.AdminExtension
import com.rekindle.book.store.domain.factory.FactoryKey.BOOKSTORE
import com.rekindle.book.store.domain.factory.FactoryKit
import com.rekindle.book.store.domain.factory.bookstore.BookstoreKey.STD_BOOKSTORE_ACTIVE
import com.rekindle.book.store.domain.tags.ComponentTest
import com.rekindle.book.store.domain.valueobjects.Bookstore
import com.rekindle.book.store.serenity.rest.controllers.bookstore.BookstoreController
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import strikt.api.expectThat
import strikt.assertions.isNotNull

@ComponentTest
@ExtendWith(AdminExtension::class)
internal class BookstoreServiceComponentTest @Inject constructor(
    private var factoryKit: FactoryKit,
    private var bookstoreController: BookstoreController
) {

    @Test
    fun `create new bookstore in Rekindle Bookstore Network`() {
        var bookstore : Bookstore = factoryKit.factory<Bookstore>(BOOKSTORE).create(STD_BOOKSTORE_ACTIVE)
        bookstore = bookstoreController.postSuccessfully(bookstore)
        expectThat(bookstore.id).isNotNull()
    }

}