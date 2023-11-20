package com.ecommercewebsite.service;

import com.ecommercewebsite.model.request.LogInRequest;
import com.ecommercewebsite.model.request.SignUpRequest;
import com.ecommercewebsite.model.response.LoginResponse;
import com.ecommercewebsite.model.response.SignUpResponse;

public interface AccountService {
    SignUpResponse signUp(SignUpRequest signUpRequest);

    LoginResponse logIn(LogInRequest logInRequest);

    Boolean verifyTest(String token);
}
