package com.phuc.english.english_exam_spring.utils;

public enum AnswerEnum {
    CORRECT(1),
    IN_CORRECT(0);
    public final int value;

    private AnswerEnum(int value) {
        this.value = value;
    }
}
