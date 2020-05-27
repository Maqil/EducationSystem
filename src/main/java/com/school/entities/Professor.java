package com.school.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@ToString
public class Professor extends User{

    private Integer professorAiid;

    @OneToMany(mappedBy = "professor", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Set<Todo> todos;

    @ManyToOne
    private Admin admin;

    public Professor(){

    }

    public Professor(String username, String email, String password, String firstname, String lastname, Boolean enabled) {
        super(username, email, password, firstname, lastname, enabled, new Role(3L));
        System.out.println(email);
    }
}
