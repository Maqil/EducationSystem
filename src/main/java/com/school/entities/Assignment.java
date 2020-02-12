package com.school.entities;

import lombok.*;

import javax.persistence.*;

@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer assignementAiid;

    @ManyToOne
    private StudentGrade studentGrade;

    @ManyToOne
    private Todo todo;

    private Boolean isDone = false;
}
