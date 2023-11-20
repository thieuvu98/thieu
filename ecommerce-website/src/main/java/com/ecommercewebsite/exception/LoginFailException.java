package com.ecommercewebsite.exception;

import jakarta.validation.constraints.NotBlank;

public class LoginFailException extends RuntimeException {
    public LoginFailException(String msg) {
        super(msg);
    }
}
