package com.ecommercewebsite.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ecommercewebsite.model.entity.Account;
import com.ecommercewebsite.service.JwtService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class JwtServiceImpl implements JwtService {

    private final Algorithm algorithm;
    private final JWTVerifier jwtVerifier;

    public JwtServiceImpl(@Value("${app.jwt.secret.account}") String secretJwt) {
        this.algorithm = Algorithm.HMAC256(secretJwt);
        this.jwtVerifier = JWT.require(this.algorithm).build();
    }

    public String sign(Account account) {
        return JWT.create()
                .withIssuedAt(Instant.now())
                .withClaim("id", account.getId())
                .withClaim("username", account.getUsername())
                .sign(this.algorithm);
    }

    public DecodedJWT verify(String token) {
        try {
            return jwtVerifier.verify(token);
        } catch (Exception e) {
            log.error(e);
            return null;
        }
    }
}
