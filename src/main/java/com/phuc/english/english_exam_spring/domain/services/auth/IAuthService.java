package com.phuc.english.english_exam_spring.domain.services.auth;

import com.phuc.english.english_exam_spring.domain.dtos.user.JWTResponse;
import com.phuc.english.english_exam_spring.domain.dtos.user.RegisterUserRequest;
import com.phuc.english.english_exam_spring.domain.dtos.user.UserLoginRequest;
import com.phuc.english.english_exam_spring.domain.dtos.user.UserResponse;

public interface IAuthService {
    JWTResponse register(RegisterUserRequest registerUserRequest);
    JWTResponse login(UserLoginRequest loginRequest);
    UserResponse refreshToken(String refreshToken);
}
