package com.phuc.english.english_exam_spring.infrastructure.datas.entites;

import com.phuc.english.english_exam_spring.utils.AnswerEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "question_answers")
public class QuestionAnswerEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private ExamQuestionEntity question;


    @Column(name = "content")
    private String content;

    @Column(name = "is_correct")
    private int isCorrect;

    public boolean checkCorrect() {
        return isCorrect == AnswerEnum.CORRECT.value;
    }
}
