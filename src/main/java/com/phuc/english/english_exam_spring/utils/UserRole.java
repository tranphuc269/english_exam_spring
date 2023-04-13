package com.phuc.english.english_exam_spring.utils;

public enum UserRole {
    ADMIN(1),
    Student(2),
    Lecturer(3);
    public final int value;

    private UserRole(int value) {
        this.value = value;
    }

    public static String toAuthorization(int role){
        switch (role){
            case 1:
                return "Admin";
            case 2:
                return "Student";
            case 3:
                return "Lecturer";
        }
        return "";
    }
}
