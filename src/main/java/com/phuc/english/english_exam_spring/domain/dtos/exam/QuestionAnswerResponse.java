package com.phuc.english.english_exam_spring.domain.dtos.exam;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class QuestionAnswerResponse extends DataResponse {
    private Long id;
    private String content;
}
