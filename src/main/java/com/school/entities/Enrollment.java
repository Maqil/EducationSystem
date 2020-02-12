package com.school.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer enrollmentAiid;

    @ManyToOne
    private StudentGrade studentGrade;

    @ManyToOne
    private Subject subject;

    @OneToMany(mappedBy = "enrollment", fetch = FetchType.EAGER)
    private Set<Assignment> assignments;
}
