package com.phuc.english.english_exam_spring.domain.dtos.exam;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Data
@Getter
@Builder
@Setter
public class ExamQuestionResponse {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("updated_at")
    private Date updatedAt;

    @JsonProperty("question_text")
    private String questionText;

    @JsonProperty("question_case")
    private int questionCase;

    List<QuestionAnswerResponse> answers;
}
