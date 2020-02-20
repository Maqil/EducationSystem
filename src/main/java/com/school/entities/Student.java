package com.school.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.repository.StudentRepository;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentAiid;
    private String fullName;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Set<StudentGrade> registrations;

    @ManyToOne
    private Admin admin;
}
