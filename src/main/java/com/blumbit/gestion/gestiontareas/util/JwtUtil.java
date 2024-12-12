package com.blumbit.gestion.gestiontareas.util;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

@Component
public class JwtUtil {

    private static String SECRET_KEY = "gestion-tareas";

    private static Algorithm ALGORITHM = Algorithm.HMAC256(SECRET_KEY);

    public  String createToken(String username){
        return JWT.create()
                .withSubject(username)
                .withIssuer("gestion-tareas")
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() * TimeUnit.DAYS.toMillis(15)))
                .sign(ALGORITHM);
    }

    public boolean validToken(String token){
        try {
            JWT.require(ALGORITHM)
            .build()
            .verify(token);
            return true;
        } catch (JWTVerificationException e) {
            return false;
        }
    }

    public String getUsername(String token){
        return JWT.require(ALGORITHM)
        .build().verify(token)
        .getSubject();
    }

}
