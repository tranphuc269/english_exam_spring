package com.phuc.english.english_exam_spring.domain.services.exam;

import com.phuc.english.english_exam_spring.domain.dtos.exam.ExamListResponse;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface IExamService {
    List<ExamListResponse> getExams();
    ExamListResponse detailExam(Long id) throws ChangeSetPersister.NotFoundException;
}
