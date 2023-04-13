package com.phuc.english.english_exam_spring.domain.services.exam;

import com.phuc.english.english_exam_spring.domain.dtos.exam.ExamListResponse;
import com.phuc.english.english_exam_spring.infrastructure.datas.entites.ExamEntity;
import com.phuc.english.english_exam_spring.infrastructure.datas.repository.exam.IExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExamServiceImpl implements IExamService {

    @Autowired
    private IExamRepository examRepository;

    @Override
    public List<ExamListResponse> getExams() {
        List<ExamEntity> exams = examRepository.findAll();
        List<ExamListResponse> examResponses = new ArrayList<>();
        exams.forEach(examEntity -> {
            examResponses.add(ExamListResponse
                    .builder()
                    .id(examEntity.getId())
                    .examDescription(examEntity.getExamDescription())
                    .examName(examEntity.getExamName())
                    .creatorId(examEntity.getCreatorId())
                    .examStartTime(examEntity.getExamStartTime())
                    .examEndTime(examEntity.getExamEndTime())
                    .build());
        });
        return examResponses;
    }
}
