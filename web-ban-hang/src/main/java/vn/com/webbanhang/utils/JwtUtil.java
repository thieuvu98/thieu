package vn.com.webbanhang.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import vn.com.webbanhang.entity.Account;
import vn.com.webbanhang.models.Claims;

import java.time.Duration;
import java.time.Instant;
import java.util.Collection;
import java.util.Date;
import java.util.IllegalFormatCodePointException;

@Component
public class JwtUtil {
    private static final String SEPARATOR  = "thieu";

    private JedisPool jedisPool;
    private Algorithm algorithm;
    private JWTVerifier jwtVerifier;

    // thời hạn token
    @Value("${app.jwt.ttl}")
    private Duration ttlJwt;

    //
    @Autowired
    public JwtUtil(JedisPool jedisPool, @Value("${app.jwt.ttl}") String secretJwt) {
        this.jedisPool = jedisPool;
        this.algorithm = Algorithm.HMAC256(secretJwt);
        this.jwtVerifier = JWT.require(this.algorithm).build();
    }


    public String generateJWT(vn.com.webbanhang.models.Claims claims){
        String token = JWT.create()
                .withIssuedAt(Date.from(Instant.now()))
                .withClaim("account_id", claims.getAccountId())
                .sign(this.algorithm);
        // set token
        setToken(claims.getAccountId(), token);

        return token;
    }

    public void setToken(String accountId, String token){
        try (Jedis jedis = jedisPool.getResource()){
            String key = toRedisKey(accountId, token);
            jedis.set(key, "1");
            jedis.expire(key, (int) ttlJwt.getSeconds());
        }
    }

    public DecodedJWT validateJWT(String token){
        DecodedJWT decodedJWT;
        try {
            decodedJWT = this.jwtVerifier.verify(token);
        }catch (JWTVerificationException e){
            return null;
        }
        try (Jedis jedis = jedisPool.getResource()){
            String redisKey = toRedisKey(vn.com.webbanhang.models.Claims.from(decodedJWT).getAccountId(), token);
            if (!jedis.exists(redisKey)){
                return null;
            }
            return decodedJWT;
        }
    }

    public String findNGenerateToken(Account account){
        String token = findToken(account.getUsername());
        if (token.isEmpty()){
            token = generateJWT(vn.com.webbanhang.models.Claims.from(account));
        }
        return token;
    }

    public String exportAccountId(String token) {
        DecodedJWT decodedJWT;
        try {
            decodedJWT = this.jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            return null;
        }
        return Claims.from(decodedJWT).getAccountId();
    }

    public boolean isExistKeyRedis(String redisKey){
        try (Jedis jedis = jedisPool.getResource()){
            return jedis.exists(redisKey);
        }
    }

    public void revokeTokens(String accountId, String token){
        try (Jedis jedis = jedisPool.getResource()){
            jedis.del(toRedisKey(accountId, token));
        }
    }

    public String findToken(String accountId){
        try (Jedis jedis = jedisPool.getResource()){
            Collection<String> tokens = jedis.keys(accountId + SEPARATOR + "*");
            if (tokens.isEmpty()){
                return "";
            }
            return tokens.iterator().next().replaceFirst(accountId + SEPARATOR, "");
        }
    }

    private String toRedisKey(String accountId, String token){
        return accountId + SEPARATOR + token;
    }
}
