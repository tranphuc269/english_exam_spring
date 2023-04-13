package com.phuc.english.english_exam_spring.infrastructure.datas.repository.exam;

import com.phuc.english.english_exam_spring.infrastructure.datas.entites.ExamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IExamRepository extends JpaRepository<ExamEntity, Long> {
    List<ExamEntity> getAllByCreatorIdAndDeletedAtNotNull(int creatorId);
    List<ExamEntity> findAllByDeletedAtNotNull();
}
