package com.restAPI.test;

import com.restAPI.base.AuthService;
import com.restAPI.models.request.LoginRequest;
import com.restAPI.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class loginApiTest {
    @Test(description = "Verify the login api")
    public void  loginTest()
    {
//        RestAssured.baseURI="http://64.227.160.186:8080/";
//        Response responce= (Response) given().header("Content-type","application/json").body("{\"username\": \"Ramu123@gmail.com\", \"password\": \"Ramu@123\"}")
//                .post("/api/auth/login");
//        System.out.println(responce.asPrettyString());
//        Assert.assertEquals(responce.getStatusCod e(),200);
        LoginRequest loginRequest= new LoginRequest("Ramu123@gmail.com","Ramu@123");
        AuthService service = new AuthService();
        //Response response=service.login("{\"username\": \"Ramu123@gmail.com\", \"password\": \"Ramu@123\"}");
        Response response=service.login(loginRequest);
        LoginResponse loginResponse=response.as(LoginResponse.class);
        System.out.println(response.asPrettyString());
        System.out.println(loginResponse.toString());
    }
}
