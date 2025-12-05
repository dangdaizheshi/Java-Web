package org.example.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {

    // 密钥，与测试类中保持一致
    private static final String SECRET_KEY = "NjU0MzIx";

    // 令牌有效时间12小时（毫秒）
    private static final long EXPIRATION_TIME = 1000L * 3600 * 12;

    /**
     * 生成JWT令牌
     *
     * @param claims 要存储在令牌中的数据
     * @return 生成的JWT令牌字符串
     */
    public static String generateJwt(Map<String, Object> claims) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .addClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .compact();
    }

    /**
     * 解析JWT令牌
     *
     * @param token 要解析的JWT令牌
     * @return 令牌中的载荷数据
     */
    public static Claims parseJwt(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
