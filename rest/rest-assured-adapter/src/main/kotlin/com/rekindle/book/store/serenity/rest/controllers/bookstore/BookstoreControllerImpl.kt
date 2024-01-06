package com.rekindle.book.store.serenity.rest.controllers.bookstore

import com.google.inject.Inject
import com.rekindle.book.store.domain.configuration.Configuration
import com.rekindle.book.store.domain.filters.JacksonFilters
import com.rekindle.book.store.domain.valueobjects.Bookstore
import com.rekindle.book.store.serenity.rest.specification.Specification
import io.restassured.RestAssured
import io.restassured.response.Response
import org.apache.http.HttpStatus

class BookstoreControllerImpl @Inject constructor(
    private val config: Configuration,
    private val spec: Specification
) : BookstoreController {
    override fun get(param: String): Response {
        return RestAssured.given(spec.basicSpec())
            .pathParams(mutableMapOf("bookstoreId" to param))
            .auth()
            .preemptive()
            .oauth2(spec.getAuthToken())
            .get(config.bookstoreEndpoint().bookstoreById())
    }

    override fun getSuccessfully(param: String): Bookstore {
        return this.get(param)
            .then()
            .statusCode(HttpStatus.SC_OK)
            .extract()
            .body()
            .`as`(Bookstore::class.java)
    }

    override fun getAll(): Response {
        return RestAssured.given(spec.basicSpec())
            .auth()
            .preemptive()
            .oauth2(spec.getAuthToken())
            .get(config.bookstoreEndpoint().bookstores())
    }

    override fun getAllSuccessfully(): List<Bookstore> {
        return this.getAll()
            .then()
            .statusCode(HttpStatus.SC_OK)
            .extract()
            .body()
            .jsonPath()
            .getList(".")
    }

    override fun post(t: Bookstore): Response {
        return RestAssured
            .given(spec.basicSpec())
            .body(t.toJsonStringFiltered(JacksonFilters.idFilter))
            .auth()
            .preemptive()
            .oauth2(spec.getAuthToken())
            .post(config.bookstoreEndpoint().bookstores())
    }

    override fun postSuccessfully(t: Bookstore): Bookstore {
        val id : String = this.post(t)
            .then()
            .statusCode(HttpStatus.SC_CREATED)
            .extract()
            .body()
            .jsonPath()
            .get(".")
        t.id = id
        return t
    }

    override fun put(t: Bookstore): Response {
        TODO("Not yet implemented")
    }

    override fun putSuccessfully(t: Bookstore) {
        TODO("Not yet implemented")
    }

    override fun delete(t: Bookstore): Response {
        TODO("Not yet implemented")
    }

    override fun deleteSuccessfully(t: Bookstore) {
        TODO("Not yet implemented")
    }
}