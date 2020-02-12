package com.school.entities;

import com.school.repository.StudentRepository;
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
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gradeAiid;

    private String gradeName;

    @OneToMany(mappedBy = "grade")
    private Set<StudentGrade> registrations;

    @ManyToOne
    private Admin admin;
}
