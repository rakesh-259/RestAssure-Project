package com.restAPI.test;

import com.restAPI.base.AuthService;
import com.restAPI.base.UserService;
import com.restAPI.models.request.LoginRequest;
import com.restAPI.models.request.ProfileUpdateRequest;
import com.restAPI.models.response.LoginResponse;
import com.restAPI.models.response.UserResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class ProfileUpdateTest {

    @Test(description = "Profile update test for API validation")
    public void profileUpdateTest() {
        AuthService authService = new AuthService();
        LoginRequest loginRequest = new LoginRequest("Ramu123@gmail.com", "Ramu@123");

        Response loginResponseRaw = authService.login(loginRequest);
        LoginResponse loginResponse = loginResponseRaw.as(LoginResponse.class);

        UserService userService = new UserService();
//        Map<String, Object> profileData = new HashMap<>();
//        profileData.put("id", 2389);
//        profileData.put("username", "Ramu123@gmail.com");
//        profileData.put("email", "Ramu123@gmail.com");
//        profileData.put("firstName", "RamuUpdated"); // changed here
//        profileData.put("lastName", "R");
//        profileData.put("mobileNumber", "9440023999");

//        Response updateResponse = userService.updateProfile(profileData, loginResponse.getToken());
//        Assert.assertEquals(updateResponse.getStatusCode(), 200, "Profile update failed");

//        Response profileResponse = userService.getProfile(loginResponse.getToken());
//        UserResponse updatedProfile = profileResponse.as(UserResponse.class);

        ProfileUpdateRequest request = ProfileUpdateRequest.Builder.newInstance()
                .firstName("RamuUpdated1")
                .lastName("R")
                .email("Ramu123@gmail.com")
                .mobileNumber("9440023999")
                .build();

        userService.updateProfile(request,loginResponse.getToken());

       Response response= userService.getProfile(loginResponse.getToken());
       UserResponse userResponse= response.as(UserResponse.class);
        Assert.assertEquals(userResponse.getFirstName(), "RamuUpdated1");
        System.out.println("✅ Profile updated successfully! Updated First Name: " + userResponse.getFirstName());
    }
}