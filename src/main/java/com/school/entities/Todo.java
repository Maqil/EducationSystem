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

    @ManyToOne
    private Subject subject;

    @OneToMany(mappedBy = "todo", fetch = FetchType.EAGER)
    private Set<Assignment> assignments;
}
