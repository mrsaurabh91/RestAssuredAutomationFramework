package org.automation;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PatchTest {

    @Test
    public void patchTest(){
        baseURI = "https://reqres.in";

        JSONObject request = new JSONObject();
        request.put("name","Ram");
        request.put("job","Teacher");

        given().
                header("Content-Type", "application/json").
                header("x-api-key", "pub_7e91fea1cc4a941ee79c7a6f8cad7431aa28fd8dcd339f02057bc9968298da44").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                patch("api//users/2").
                then().
                statusCode(200).
                log().all();
    }
}
