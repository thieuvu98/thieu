package com.ecommercewebsite.model.response;

public class SignUpResponse {
    private String token;

    public SignUpResponse() {
    }

    public SignUpResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public SignUpResponse setToken(String token) {
        this.token = token;
        return this;
    }
}
