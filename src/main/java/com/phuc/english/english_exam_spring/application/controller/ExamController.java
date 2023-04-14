package com.phuc.english.english_exam_spring.application.controller;


import com.phuc.english.english_exam_spring.application.response.BaseResponse;
import com.phuc.english.english_exam_spring.domain.services.exam.IExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/exams")
public class ExamController {
    @Autowired
    private IExamService service;

    @GetMapping("")
    public ResponseEntity<Object> getExams() {
        return ResponseEntity.ok(BaseResponse.success(service.getExams()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getDetailExam(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(BaseResponse.success(service.detailExam(id)));
        }catch (Exception e){
            BaseResponse.notFound();
        }
        return null;
    }
}
