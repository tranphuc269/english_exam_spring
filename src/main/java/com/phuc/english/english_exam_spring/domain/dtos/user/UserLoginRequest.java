package com.phuc.english.english_exam_spring.domain.dtos.user;


import lombok.Data;

@Data
public class UserLoginRequest {
    private String email;
    private String password;
}
