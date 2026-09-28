package org.automation;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class DeleteTest {

    @Test
    public void deleteTest(){
        baseURI = "https://reqres.in";

        given().
                delete("api//users/2").
                then().
                statusCode(204).
                log().all();
    }
}
