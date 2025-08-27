package com.restAPI.test;

import com.restAPI.base.AuthService;
import com.restAPI.base.UserService;
import com.restAPI.models.request.LoginRequest;
import com.restAPI.models.response.LoginResponse;
import com.restAPI.models.response.UserResponse;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners({com.restAPI.listeners.TestListener.class})
public class getProfileForTest {
    private static final Logger logger = LogManager.getLogger(getProfileForTest.class);

    @Test(description = "Get Profile Test for API validation")
    public void getProfileTest() {
        logger.info("🔑 Starting Get Profile API Test...");
        LoginRequest loginRequest = new LoginRequest("Ramu123@gmail.com", "Ramu@123");
        AuthService authService = new AuthService();

        logger.debug("Sending login request with username: {}", loginRequest.getUsername());
        Response response = authService.login(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class);

        logger.info("✅ Successfully logged in. Token received: {}", loginResponse.getToken());

        UserService userService = new UserService();
        response = userService.getProfile(loginResponse.getToken());
        UserResponse userResponse = response.as(UserResponse.class);

        logger.info("📄 Profile fetched successfully for user: {}", userResponse.getFirstName());
        logger.debug("Full Profile Response: {}", response.asPrettyString());

        // Add validation if needed
        if (userResponse.getFirstName() != null) {
            logger.info("🎯 Test Passed - FirstName: {}", userResponse.getFirstName());
        } else {
            logger.error("❌ Test Failed - FirstName is null in response");
        }
    }
}
