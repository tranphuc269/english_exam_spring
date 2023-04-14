package com.phuc.english.english_exam_spring.domain.dtos.exam;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Data
@Builder
@Getter
@Setter
public class ExamDetailResponse extends DataResponse{
    private Long id;

    @JsonProperty("exam_name")
    private String examName;
    @JsonProperty("exam_description")
    private String examDescription;
    @JsonProperty("exam_start_time")
    private Date examStartTime;
    @JsonProperty("exam_end_time")
    private Date examEndTime;
    @JsonProperty("questions")
    List<ExamQuestionResponse> questions;

}
