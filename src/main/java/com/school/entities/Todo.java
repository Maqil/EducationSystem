package com.school.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer todoAiid;
    private String description;

    @ManyToOne
    private Professor professor;

    @OneToMany(mappedBy = "todos")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Student> students;
}
