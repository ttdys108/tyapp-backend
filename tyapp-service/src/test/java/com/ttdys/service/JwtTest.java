package com.ttdys.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.util.Date;

@Slf4j
public class JwtTest {

    @Test
    public void test() {
        Algorithm algorithm = Algorithm.HMAC256("secret");
        String token = JWT.create().withIssuer("ttdys").withExpiresAt(DateUtils.addSeconds(new Date(), 2)).withSubject("123").sign(algorithm);
        log.info("token: {}", token);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JWTVerifier jwtVerifier = JWT.require(algorithm).withIssuer("ttdys").build();
        DecodedJWT jwt = jwtVerifier.verify(token);
        System.out.println(jwt.getExpiresAt());
    }

}
