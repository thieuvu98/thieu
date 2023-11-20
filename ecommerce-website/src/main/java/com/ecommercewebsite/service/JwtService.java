package com.ecommercewebsite.service;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.ecommercewebsite.model.entity.Account;

public interface JwtService {
    String sign(Account account);

    DecodedJWT verify(String token);
}
