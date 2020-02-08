package com.school.entities;


import lombok.*;

import javax.persistence.*;
import java.util.Collection;

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

    @ManyToMany
    private Collection<Todo> todos;
}
