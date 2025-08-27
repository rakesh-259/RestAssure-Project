package com.restAPI.test;


import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

public class HttpRequest {

    @Test
    public void  getUser()
    {
        RestAssured.given().
        when().get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("page", Matchers.equalTo(2))
                .log().all();

    }

}
