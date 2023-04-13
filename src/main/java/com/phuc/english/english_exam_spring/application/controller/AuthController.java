package com.phuc.english.english_exam_spring.application.controller;
import com.phuc.english.english_exam_spring.application.response.BaseResponse;
import com.phuc.english.english_exam_spring.domain.dtos.user.JWTResponse;
import com.phuc.english.english_exam_spring.domain.dtos.user.UserLoginRequest;
import com.phuc.english.english_exam_spring.domain.services.auth.IAuthService;
import com.phuc.english.english_exam_spring.infrastructure.datas.entites.UserEntity;
import com.phuc.english.english_exam_spring.infrastructure.datas.repository.auth.IAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/auth")
public class AuthController {

    @Autowired
    private IAuthRepository authRepository;

    @Autowired
    private IAuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserLoginRequest userRequest) {
        JWTResponse jwtResponse = authService.login(userRequest);
        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("Set-Cookie", "refreshToken=" + jwtResponse.getRefreshToken());
        return new ResponseEntity<>(jwtResponse, httpHeaders, HttpStatus.OK);
    }

    @Autowired
    @GetMapping("")
    public Object getUsers(){
        List<UserEntity> users = authRepository.findAll();
        return BaseResponse.success(users);
    }
}
