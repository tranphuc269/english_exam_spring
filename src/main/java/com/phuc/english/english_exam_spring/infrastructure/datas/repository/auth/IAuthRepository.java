package com.phuc.english.english_exam_spring.infrastructure.datas.repository.auth;

import com.phuc.english.english_exam_spring.infrastructure.datas.entites.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAuthRepository
        extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);

}
