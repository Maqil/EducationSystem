package com.school.entities;


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
    private Set<StudentGrade> registrations;

    @ManyToOne
    private Admin admin;
}
