package vn.com.webbanhang.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.webbanhang.request.LoginRequest;
import vn.com.webbanhang.request.SignupRequest;
import vn.com.webbanhang.service.AccountService;
import vn.com.webbanhang.utils.JwtUtil;

@RestController
@RequestMapping ("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody @Valid SignupRequest signupRequest) {
        if(accountService.signUp(signupRequest)) {
            String jwt = JwtUtil.generateJWT(signupRequest.getUsername());
            return ResponseEntity.ok(jwt);
        }else{
            return ResponseEntity.badRequest().body("Account already exists");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequest loginRequest) {
        if (accountService.logIn(loginRequest)) {
            return ResponseEntity.ok("Login success fully");
        } else {
            return ResponseEntity.badRequest().body("Login error");
        }
    }
}