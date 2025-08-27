package com.restAPI.test;

import com.restAPI.base.AuthService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class forgetPasswordTest {

    @Test(description = "Forget Password started in api..........")
    public void forgetPasswordTest()
    {
        AuthService authService= new AuthService();
        Response response=authService.forgotPassword("jack123@email.com");
        System.out.println(response.asPrettyString());
    }
}
