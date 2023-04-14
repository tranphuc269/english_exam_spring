package com.phuc.english.english_exam_spring.domain.services.exam;

import com.phuc.english.english_exam_spring.domain.dtos.exam.ExamDetailResponse;
import com.phuc.english.english_exam_spring.domain.dtos.exam.ExamListResponse;
import com.phuc.english.english_exam_spring.domain.dtos.exam.ExamQuestionResponse;
import com.phuc.english.english_exam_spring.infrastructure.datas.entites.ExamEntity;
import com.phuc.english.english_exam_spring.infrastructure.datas.repository.exam.IExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
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
                    .creatorId(examEntity.getCreatorUser().getId())
                    .examStartTime(examEntity.getExamStartTime())
                    .examEndTime(examEntity.getExamEndTime())
                    .build());
        });
        return examResponses;
    }

    @Override
    public ExamListResponse detailExam(Long id) throws ChangeSetPersister.NotFoundException {
        ExamEntity exam = examRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
        ExamDetailResponse examResponse = ExamDetailResponse
                .builder()
                .id(exam.getId())
                .examDescription(exam.getExamDescription())
                .examEndTime(exam.getExamEndTime())
                .examStartTime(exam.getExamStartTime())
                .build();
        List<ExamQuestionResponse> questions = new ArrayList<>();
        exam.getQuestions().forEach(questionEntity -> {
            questions.add(ExamQuestionResponse
                    .builder()
                    .id(questionEntity.getId())
                    .questionCase(questionEntity.getQuestionCase())
                    .questionText(questionEntity.getQuestionText())
                    .build());
        });

        return null;
    }
}
