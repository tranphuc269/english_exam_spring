package com.phuc.english.english_exam_spring;

import com.phuc.english.english_exam_spring.infrastructure.datas.entites.UserEntity;
import com.phuc.english.english_exam_spring.infrastructure.datas.repository.auth.IAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = {"com.phuc.english.english_exam_spring.infrastructure.datas.repository"})
//@EntityScan(basePackages = {"com.phuc.english.english_exam_spring.infrastructure.datas.entites"})
public class EnglishExamSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(EnglishExamSpringApplication.class, args);
    }

}
