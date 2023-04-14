package com.phuc.english.english_exam_spring.domain.dtos.exam;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Builder
@Setter
public class ExamQuestionResponse extends DataResponse{
    private Long id;
    private String questionText;

    private int questionCase;

    List<QuestionAnswerResponse> answers;
}
