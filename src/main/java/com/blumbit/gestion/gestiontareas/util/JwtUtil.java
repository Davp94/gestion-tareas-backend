package com.blumbit.gestion.gestiontareas.util;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Component
public class JwtUtil {

    private static String SECRET_KEY = "374b05db15f11df00fd233b7ba1f4d784f647596f39eef7f078bc2fa1ab6ea52eadf95c779d142f3f304d1685c5bd81a53911c22db3e93f172a71021965e2db7564990ac6582e63af6f133d91eda278771c0f2b910d295f63722765c1640988359d36cc2cd1a5fe00b9aafe39dcccf66c246ed2e25c5a022abd3e50c6d7780a86c4f82d611a43f222d22609913cc04fd18f091f137ecda2e70eb51abd2adb6acab32c7740f6bc670b6c95765991e02c7f7a9233977fab005ab42c7a3b83716dcb4093b9009e36d0daaad568504b17b868cb2b90ff39225b3cdfef824286afe0fcaaa76369b87023800a623a009d6e45b33b0dfeafa693c68ee37e38705b61b5f";

    private static Algorithm ALGORITHM = Algorithm.HMAC256(SECRET_KEY);

    public  String createToken(String username){
        return JWT.create()
                .withSubject(username)
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
        } catch (Exception e) {
            return false;
        }
    }

    public String getUsername(String token){
        return JWT.require(ALGORITHM)
        .build().verify(token)
        .getSubject();
    }

}
