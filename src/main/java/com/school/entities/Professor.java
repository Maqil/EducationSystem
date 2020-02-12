package com.school.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer professorAiid;
    private String fullName;
    private String email;
    private String phone;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Subject> subjects;

    @OneToMany(mappedBy = "professor", fetch = FetchType.EAGER)
    private Collection<Todo> todos;
}
