package com.school.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentGradeSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stdGradeSubjectAiid;

    @ManyToOne
    private StudentGrade studentGrade;

    @ManyToOne
    private Subject subject;

    @OneToMany(mappedBy = "stdGradeSubject")
    private Set<StdGrdSbjTd> todos;
}
