package com.github.abigail830.jwtdemo.infrastructure;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.util.Date;

import static com.github.abigail830.jwtdemo.infrastructure.Constant.EXPIRATION_TIME;

@Component
public class JWTAuth0Util {

    private static final String SECRET = "Secret";

    public String sign(String username) throws JWTCreationException {
        return JWT.create()
                .withSubject(username)
                .withIssuer("jwt-demo")
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SECRET));
    }

    public DecodedJWT verify(String token) throws JWTVerificationException {
        Algorithm algorithm = Algorithm.HMAC512(SECRET);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("jwt-demo")
                .build();
        return verifier.verify(token);
    }

    public DecodedJWT decode(String token) throws JWTDecodeException {
        return JWT.decode(token);
    }
}
