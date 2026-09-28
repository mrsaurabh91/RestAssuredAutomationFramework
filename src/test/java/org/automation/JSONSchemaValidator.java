package org.automation;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JSONSchemaValidator {

    @Test
    public void getRequest2() {
        baseURI = "https://reqres.in";
        given().
            get("/api/users?page=2").
                then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schema.json")).
                statusCode(200);

    }
}
