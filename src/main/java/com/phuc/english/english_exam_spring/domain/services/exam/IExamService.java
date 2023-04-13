package com.phuc.english.english_exam_spring.domain.services.exam;

import com.phuc.english.english_exam_spring.domain.dtos.exam.ExamListResponse;

import java.util.List;

public interface IExamService {
    List<ExamListResponse> getExams();
}
