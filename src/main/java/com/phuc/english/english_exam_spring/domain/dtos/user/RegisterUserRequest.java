package com.phuc.english.english_exam_spring.domain.dtos.user;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;

import java.util.Date;

@Data
@Getter
@Setter
public class RegisterUserRequest {
    private String name;
    private String email;
    private String password;

    @JsonProperty("date_of_birth")
    private Date dateOfBirth;
    @JsonProperty("phone_number")
    private String phoneNumber;
    private String address;
    private int role;
}
