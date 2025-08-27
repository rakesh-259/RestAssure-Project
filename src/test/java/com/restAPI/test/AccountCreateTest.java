package com.restAPI.test;

import com.restAPI.base.AuthService;
import com.restAPI.models.request.signUpRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountCreateTest {
    @Test(description = "Account Create for api validation")
    public  void  createAccountTest(){
        signUpRequest signuprequest = new signUpRequest.Builder()
                .username("jack123")
                .password("securePass")
                .email("jack123@email.com")
                .firstName("Jack")
                .lastName("L")
                .mobileNumber("1457721135")
                .build();
        AuthService authService= new AuthService();
        Response response=authService.signUp(signuprequest);
        Assert.assertEquals(response.asPrettyString(),"User registered successfully!");
        System.out.println(response.asPrettyString());

    }
}
