package com.github.abigail830.jwtdemo.infrastructure;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import java.util.Date;

import static com.github.abigail830.jwtdemo.infrastructure.Constant.EXPIRATION_TIME;

public class JWTAuth0Util {

    private static final String SECRET = "Secret";

    public String sign() {
        try {
            return JWT.create()
                    .withSubject("SaraQian")
                    .withIssuer("jwt-demo")
                    .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                    .sign(Algorithm.HMAC512(SECRET));
        } catch (JWTCreationException exception) {
            System.out.println("Invalid signature/claims");
            return null;
        }
    }

    public String verify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC512(SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .build();
            return verifier.verify(token).getIssuer();

        } catch (JWTVerificationException exception) {
            System.out.println("Invalid signature/claims");
            return null;
        }
    }
}
