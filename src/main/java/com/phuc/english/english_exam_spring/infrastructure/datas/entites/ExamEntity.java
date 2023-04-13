package com.phuc.english.english_exam_spring.infrastructure.datas.entites;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import javax.persistence.*;
import java.util.Date;


@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "exams")
public class ExamEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "exam_name")
    private String examName;
    @Column(name = "exam_description")
    private String examDescription;

    @Column(name = "exam_start_time")
    private Date examStartTime;

    @Column(name = "exam_end_time")
    private Date examEndTime;
    @Column(name = "creator_id", insertable = false, updatable = false)
    private int creatorId;
//    @ManyToOne
//    @JoinColumn(name = "creator_id", nullable = false)
//    private UserEntity user;

}
