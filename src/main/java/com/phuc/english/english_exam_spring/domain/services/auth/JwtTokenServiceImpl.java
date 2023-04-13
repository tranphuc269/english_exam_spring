package com.phuc.english.english_exam_spring.domain.services.auth;

import com.phuc.english.english_exam_spring.config.security.JwtService;
import com.phuc.english.english_exam_spring.infrastructure.datas.entites.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;

@Service
public class JwtTokenServiceImpl implements JwtTokenService {


    @Value("${security.jwt.expiration}")
    private long jwtExpiration;

    @Value("${security.jwt.refresh-token.expiration}")
    private long refreshExpiration;

    @Override
    public String findUsernameByToken(String token) {
        return getClaims(token).getSubject();
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(JwtService.SECRET_KEY.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    @Override
    public boolean validateToken(String token, UserDetails userDetails) {
        String username = findUsernameByToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

    @Override
    public String generateToken(UserEntity user){
        return buildToken(user, jwtExpiration);
    }

    @Override
    public String generateRefresh(UserEntity user){
        return buildToken(user, refreshExpiration);
    }

    private String buildToken(UserEntity user, long jwtExpiration) {
        return Jwts.builder()
                .setClaims(new HashMap<>())
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .signWith(Keys.hmacShaKeyFor(JwtService.SECRET_KEY.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }
}