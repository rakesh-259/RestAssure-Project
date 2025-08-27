package com.restAPI.models.request;

public class signUpRequest {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String mobileNumber;

    // ✅ Private constructor (only Builder can create)
    public signUpRequest(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.email = builder.email;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.mobileNumber = builder.mobileNumber;
    }

    // ✅ Getters (No Setters to make it immutable, if you want immutability)
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    // ✅ Builder Static Class
    public static class Builder {
        private String username;
        private String password;
        private String email;
        private String firstName;
        private String lastName;
        private String mobileNumber;

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder mobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        // ✅ build() method returns final Object
        public signUpRequest build() {
            return new signUpRequest(this);
        }
    }

    // ✅ toString() for debugging
    @Override
    public String toString() {
        return "signUpRequest{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}
