package com.restAPI.base;

import com.restAPI.filters.LoggingFilter;
import com.restAPI.models.request.LoginRequest;
import com.restAPI.models.request.signUpRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class BaseService {

    private  static final String Base_URL="http://64.227.160.186:8080/";
    private RequestSpecification requestSpecification;

    static{
        RestAssured.filters(new LoggingFilter());
    }

    public BaseService()
    {

        requestSpecification=  given().baseUri(Base_URL);
    }
    protected void setAuthToken(String token) {
        requestSpecification.header("Authorization", "Bearer " + token);
    }

    protected Response postRequest (Object payLoad, String endPoint)
    {
        return  requestSpecification.contentType(ContentType.JSON).body(payLoad).post(endPoint);
    }
    protected Response putRequest(Object payload, String endPoint) {
        return requestSpecification.contentType(ContentType.JSON).body(payload).put(endPoint);
    }

    protected  Response getRequest(String endPoint)
    {
        return requestSpecification.get(endPoint);
    }
//    protected Response postRequest (signUpRequest payLoad, String endPoint)
//    {
//        return  requestSpecification.contentType(ContentType.JSON).body(payLoad).post(endPoint);
//    }
//    protected Response postRequest(Object payload, String endPoint) {
//        return requestSpecification.contentType(ContentType.JSON).body(payload).post(endPoint);
//    }


}
