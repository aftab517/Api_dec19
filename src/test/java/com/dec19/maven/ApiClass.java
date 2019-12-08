package com.dec19.maven;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class ApiClass {

    @Test

    public void listUsers() {

        Response response = given()
                .when().get("https://reqres.in/api/users?page=2");

        response.prettyPrint();

        response.then()
                .body("page", is(2))
                .body("data.first_name", hasItems("Eve", "Charles", "Tracey"))
                .body("total_pages", Matchers.is(equalTo(4)))
                .body("data.id", hasItems(4, 5, 6))
                .statusCode(200);
    }


}
