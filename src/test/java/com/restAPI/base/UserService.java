package com.restAPI.base;

import com.restAPI.models.request.ProfileUpdateRequest;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

import java.util.Map;
import java.util.Objects;

public class UserService extends BaseService {
    private static final String BASE_PATH = "/api/users/";
   private ResponseSpecification responseSpecification;

   public Response getProfile(String token){
       setAuthToken(token);
       return getRequest(BASE_PATH+"profile");
   }
   public Response updateProfile(Map<String, Object> payload, String token){
       setAuthToken(token);
       return putRequest(payload,BASE_PATH+"profile");
   }
        public Response updateProfile(ProfileUpdateRequest payload, String token){
        setAuthToken(token);
        return putRequest(payload,BASE_PATH+"profile");
    }

    public Response changePassword(Map<String, String> payload) {
        return postRequest(payload, BASE_PATH + "change-password");
    }

//
//    public Response updateProfile(Map<String, Object> payload) {
//        return requestSpecification.contentType(ContentType.JSON).body(payload).put(BASE_PATH + "profile");
//    }
//
//    public Response deleteProfile() {
//        return requestSpecification.delete(BASE_PATH + "profile");
//    }
//
//    public Response patchProfile(Map<String, Object> payload) {
//        return requestSpecification.contentType(ContentType.JSON).body(payload).patch(BASE_PATH + "profile");
//    }

}
