package com.school.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @OneToMany(mappedBy = "studentGrade", fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Set<Assignment> assignments;
}
