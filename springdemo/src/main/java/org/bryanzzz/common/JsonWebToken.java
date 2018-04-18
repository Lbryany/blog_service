package org.bryanzzz.common;

import com.sun.javafx.geom.transform.Identity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import javax.crypto.SecretKey;
import java.util.Date;

public class JsonWebToken {

    private static SecretKey key = generalKey();

    private static SecretKey generalKey() {
        return MacProvider.generateKey();
    }

    public static String createJWT(String id, String subject, long ttlMillis){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;
        //TODO 暂时用一个KEY 等以后熟悉了，变成添加cookie，然后用cookie的key去解密
        SecretKey secretKey = key;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        JwtBuilder jwtBuilder = Jwts.builder().setId(id).setSubject(subject).setIssuedAt(now).signWith(signatureAlgorithm, secretKey);
        if(ttlMillis >= 0){
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            jwtBuilder.setExpiration(exp);
        }
        return jwtBuilder.compact();
    }

    public static Claims parseJWT(String token){
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        return claims;
    }

}