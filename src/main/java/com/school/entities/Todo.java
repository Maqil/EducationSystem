package com.school.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer todoAiid;
    private String description;

    @ManyToOne
    private Professor professor;

    @OneToMany(mappedBy = "todo", fetch = FetchType.EAGER)
    private Set<StdGrdSbjTd> todos;

//    @OneToMany(mappedBy = "todos")
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)

//    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "todos")
//    private Collection<Student> students;

}
