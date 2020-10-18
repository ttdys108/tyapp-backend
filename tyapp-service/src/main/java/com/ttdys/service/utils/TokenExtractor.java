package com.ttdys.service.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class TokenExtractor {
    private TokenExtractor() {}

    private static final String bearerTokenPrefix = "Bearer ";

    public static String extractToken(HttpServletRequest request) {
        String auth = request.getHeader("Authorization");
        if(StringUtils.isBlank(auth) || !auth.startsWith(bearerTokenPrefix))
            return null;
        return auth.substring(bearerTokenPrefix.length());
    }

}
