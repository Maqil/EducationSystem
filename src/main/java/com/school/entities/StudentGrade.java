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
public class StudentGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer registrationAiid;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Grade grade;

//    @ManyToMany(mappedBy = "stdGrades", fetch = FetchType.EAGER)
//    private Set<Subject> subjects;

    @OneToMany(mappedBy = "studentGrade", fetch = FetchType.EAGER)
    private Set<Assignment> assignments;
}
