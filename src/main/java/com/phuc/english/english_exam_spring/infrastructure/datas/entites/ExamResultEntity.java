package com.phuc.english.english_exam_spring.infrastructure.datas.entites;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "exam_results")
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ExamResultEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_id")
    private ExamEntity exam;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity ownerUser;

    @Column(name = "total_score")
    private Long totalScore;

    @Column(name = "reading_score")
    private Long readingScore;

    @Column(name = "listening_score")
    private Long listeningScore;

    @Column(name = "num_correct_reading")
    private Long numCorrectReading;

    @Column(name = "num_correct_listening")
    private Long numCorrectListening;


    @Column(name = "tab_switch_count")
    private Long tabSwitchCount;

}
