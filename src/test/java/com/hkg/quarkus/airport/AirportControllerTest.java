package com.hkg.quarkus.airport;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class AirportControllerTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/airport")
          .then()
             .statusCode(200)
             .body(is("hello"));
    }

}