package com.phuc.english.english_exam_spring.infrastructure.datas.repository.exam;

import com.phuc.english.english_exam_spring.infrastructure.datas.entites.ExamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IExamRepository extends JpaRepository<ExamEntity, Long> {
    List<ExamEntity> findAllByDeletedAtNotNull();
}
