package vn.com.webbanhang.service;

import vn.com.webbanhang.request.LoginRequest;
import vn.com.webbanhang.request.SignupRequest;

public interface AccountService {
    boolean signUp(SignupRequest signupRequest);

    boolean logIn(LoginRequest loginRequest);
}
