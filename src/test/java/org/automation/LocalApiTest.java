package org.automation;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class LocalApiTest {

    @Test
    public void getRequest() {
        baseURI = "http://localhost:3000";
        given().
                get("/users").
                then().
                statusCode(200);
                //           log().all();
                //        body("users[1].firstName", equalTo("Saurabh"));
        //  body("firstName",hasItems("Saurabh","Tanay"));
    }

    @Test
    public void getRequest2() {
        baseURI = "http://localhost:3000";
        Response response  = given().
                get("/users");
        Assertions.assertEquals(200,response.getStatusCode());
        ResponseBody responseBody = response.getBody();
        System.out.println("responseBody.peek()="+responseBody.peek());
        System.out.println("response.prettyPrint()="+response.prettyPrint());
        System.out.println("response.asPrettyString()="+response.asPrettyString());
        System.out.println("response.print()"+response.print());

        //           log().all();
        //        body("users[1].firstName", equalTo("Saurabh"));
        //  body("firstName",hasItems("Saurabh","Tanay"));
    }

    @Disabled
    @Test
    public void postRequest() {
        baseURI = "http://localhost:3000";

        JSONObject request = new JSONObject();
        request.put("firstName", "Ram");
        request.put("lastName", "Singh");
        request.put("subjectId", "4");


        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("/users").
                then().
                statusCode(201).
                log().all();

    }

    @Disabled
    @Test
    public void putRequest() {
        baseURI = "http://localhost:3000";

        JSONObject request = new JSONObject();
        request.put("firstName", "Laxman");
        request.put("lastName", "Singh");
        request.put("subjectId", "4");
        request.put("id", "3");

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                put("/users/3").
                then().
                statusCode(200).
                log().all();

    }
}
