package org.automation;


import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class SoapXmlTest {

    @Test
    public void validateSoapXml(){
        baseURI = "https://soap-service-free.mock.beeceptor.com";
        given().
                header("Content-Type", "application/xml").
                accept(ContentType.XML).
                get("/CountryInfoService?WSDL").
                then().statusCode(200).log().all();


    }

}
