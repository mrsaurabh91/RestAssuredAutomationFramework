package org.automation;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.protocol.HTTP;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

public class GetTest {


    @Disabled
    @Test
    public void test1() {
        //
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader(HTTP.CONTENT_TYPE));

        Assertions.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void test2() {
        baseURI = "https://reqres.in";
        given().
                get("/api/users?page=2").
                then().
                statusCode(200).
                body("data[1].first_name",equalTo("Lindsay")).
                body("data.first_name",hasItems("Michael","Lindsay"));
    }
}
