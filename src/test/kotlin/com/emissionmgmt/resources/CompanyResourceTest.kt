package com.emissionmgmt.resources

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
class CompanyResourceTest {

    @Test
    fun testHelloEndpoint() {
        given()
          .`when`().get("/companies")
          .then()
             .statusCode(200)
             .body(`is`("Hello from RESTEasy Reactive"))
    }

}