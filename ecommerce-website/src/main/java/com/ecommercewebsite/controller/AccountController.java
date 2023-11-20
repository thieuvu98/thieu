package com.ecommercewebsite.controller;

import com.ecommercewebsite.model.request.LogInRequest;
import com.ecommercewebsite.model.request.SignUpRequest;
import com.ecommercewebsite.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/test")
    public ResponseEntity<?> verifyToken(@RequestBody String token) {
        return ResponseEntity.ok(accountService.verifyTest(token));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody @Valid SignUpRequest signUpRequest){
        return ResponseEntity.ok(accountService.signUp(signUpRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<?> logIn(@RequestBody @Valid LogInRequest logInRequest){
        return ResponseEntity.ok(accountService.logIn(logInRequest));
    }
}
