package com.ecommercewebsite.service.impl;

import com.ecommercewebsite.exception.AccountAlreadyExistException;
import com.ecommercewebsite.exception.LoginFailException;
import com.ecommercewebsite.exception.UsernameNotFoundException;
import com.ecommercewebsite.model.entity.Account;
import com.ecommercewebsite.model.request.LogInRequest;
import com.ecommercewebsite.model.request.SignUpRequest;
import com.ecommercewebsite.model.response.LoginResponse;
import com.ecommercewebsite.model.response.SignUpResponse;
import com.ecommercewebsite.repository.AccountRepository;
import com.ecommercewebsite.service.AccountService;
import com.ecommercewebsite.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;

    @Override
    public SignUpResponse signUp(SignUpRequest signUpRequest) {
        if (accountRepository.findByUsername(signUpRequest.getUsername()).isPresent()){
            throw new AccountAlreadyExistException("Account already exist with username: "+signUpRequest.getUsername());
        }

        Account account = new Account();
        account.setName(signUpRequest.getName());
        account.setUsername(signUpRequest.getUsername());
        account.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        accountRepository.save(account);
        return new SignUpResponse()
                .setToken(jwtService.sign(account));
    }

    @Override
    public LoginResponse logIn(LogInRequest logInRequest) {
        Account account = accountRepository.findByUsername(logInRequest.getUsername())
                .orElseThrow(()-> new UsernameNotFoundException("Account not found with username: "+logInRequest.getUsername()));
        var matched = passwordEncoder.matches(logInRequest.getPassword(), account.getPassword());
        if (!matched) {
            throw new LoginFailException("Login failed, username: " + logInRequest.getUsername());
        }
        return new LoginResponse()
                .setToken(jwtService.sign(account));
    }

    @Override
    public Boolean verifyTest(String token) {
       var decodedJWT = jwtService.verify(token);
       decodedJWT.getClaims();
        return true;
    }


}
