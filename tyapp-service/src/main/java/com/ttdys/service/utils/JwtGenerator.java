package com.ttdys.service.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class JwtGenerator {

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.issuer}")
    private String issuer;
    @Value("${token.expires-in}")
    private Integer expiresIn;

    public String generate(Long uid) {
        Date expiresAt = DateUtils.addSeconds(new Date(), expiresIn);
        return JWT.create().withIssuer(issuer).withSubject(String.valueOf(uid))
                .withExpiresAt(expiresAt).sign(getAlgorithm());
    }

    /**
     *
     * @param token
     * @return null if token invalid
     */
    public DecodedJWT verify(String token) {
        try {
            JWTVerifier verifier = JWT.require(getAlgorithm()).withIssuer(issuer).build();
            return verifier.verify(token);
        } catch (JWTVerificationException e) {
            log.error("jwt token <{}> verify failed", token, e);
            return null;
        }
    }

    /**
     *
     * @param token
     * @return null if token invalid
     */
    public Long extractUid(String token) {
        DecodedJWT jwt = verify(token);
        return jwt == null ? null : Long.valueOf(jwt.getSubject());
    }

    private Algorithm getAlgorithm() {
        return Algorithm.HMAC256(secret);
    }

}
