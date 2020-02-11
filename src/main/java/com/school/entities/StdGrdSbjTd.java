package com.school.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StdGrdSbjTd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stdGrdSbjTdAiid;

    @ManyToOne
    private Todo todo;

    @ManyToOne
    private StudentGradeSubject stdGradeSubject;
}
