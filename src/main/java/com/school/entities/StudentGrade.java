package com.school.entities;

import lombok.*;

import javax.persistence.*;
import javax.persistence.JoinColumn;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stdGradeAiid;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Grade grade;

    @OneToMany(mappedBy = "studentGrade")
    private Set<StudentGradeSubject> enrollment;
}
