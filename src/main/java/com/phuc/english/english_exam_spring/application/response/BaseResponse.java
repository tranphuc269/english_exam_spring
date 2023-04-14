package com.phuc.english.english_exam_spring.application.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Data
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse {
    Object data;
    String message;

    public static BaseResponse success(Object data) {
        return BaseResponse
                .builder()
                .data(data)
                .message("Success")
                .build();
    }

    public static BaseResponse failure(String message) {
        return BaseResponse
                .builder()
                .message(message)
                .build();
    }

    public static void notFound() {
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        );
    }

}
