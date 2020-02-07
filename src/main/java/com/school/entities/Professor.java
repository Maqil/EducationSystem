package com.school.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer professorAiid;
    private String fullName;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "professor")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Todo> todos;
}
