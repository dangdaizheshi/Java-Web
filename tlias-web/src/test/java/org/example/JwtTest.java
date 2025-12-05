package org.example;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static io.jsonwebtoken.SignatureAlgorithm.HS256;

public class JwtTest {
    @Test
    public void testGenerateJwt() {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("username", "admin");
        dataMap.put("password", "123456");
        String jwt = Jwts.builder().signWith(HS256, "NjU0MzIx")
                .addClaims(dataMap)
                .setExpiration(new Date(System.currentTimeMillis() + 1000 *3600 * 8))
                .compact();
        System.out.println(jwt);
    }

    @Test
    public void testParseJwt() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJwYXNzd29yZCI6IjEyMzQ1NiIsInVzZXJuYW1lIjoiYWRtaW4iLCJleHAiOjE3NjQ4Njc0NTJ9.gAyVVv4lk-BRkgb4QqftdMEKBG6a7bQI8bekZXF2Q6E";
        Claims claims = Jwts.parser()
                .setSigningKey("NjU0MzIx")
                .parseClaimsJws(token)
                .getBody();
        System.out.println(claims);
    }
}
