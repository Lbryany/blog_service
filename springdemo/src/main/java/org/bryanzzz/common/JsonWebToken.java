package org.bryanzzz.common;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import javax.crypto.SecretKey;
import java.util.Date;

public class JsonWebToken {

    public static SecretKey generalKey() {
        return MacProvider.generateKey();
    }

    public static String createJWT(String id, String subject, long ttlMillis){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;
        SecretKey secretKey = generalKey();
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        JwtBuilder jwtBuilder = Jwts.builder().setId(id).setSubject(subject).setIssuedAt(now).signWith(signatureAlgorithm, secretKey);
        if(ttlMillis > 0){
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            jwtBuilder.setExpiration(exp);
        }
        return jwtBuilder.compact();
    }

}