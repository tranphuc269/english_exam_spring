package com.phuc.english.english_exam_spring.domain.services.auth;

import com.phuc.english.english_exam_spring.infrastructure.datas.entites.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtTokenService {
    String findUsernameByToken(String token);
    boolean validateToken(String token, UserDetails userDetails);
    String generateToken(UserEntity user);
    String generateRefresh(UserEntity user);
}