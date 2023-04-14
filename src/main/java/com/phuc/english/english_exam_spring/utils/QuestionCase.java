package com.phuc.english.english_exam_spring.utils;

public enum QuestionCase {
    READING(1),
    LISTENING(2);
    public final int value;

    private QuestionCase(int value) {
        this.value = value;
    }
}
