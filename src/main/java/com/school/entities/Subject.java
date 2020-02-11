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
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subjectAiid;

    private String subjectName;

    @OneToMany(mappedBy = "subject")
    private Set<StudentGradeSubject> enrollment;
}
