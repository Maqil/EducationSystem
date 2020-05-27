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
public class Enrollment extends User {

    private Integer enrollmentAiid;

    @OneToMany(mappedBy = "enrollment", fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Set<Student> registrations;

    @ManyToOne
    private Admin admin;

    public Enrollment() {

    }

    public Enrollment(String username, String email, String password, String firstname, String lastname, Boolean enabled) {
        super(username, email, password, firstname, lastname, enabled, new Role(4L));
    }

    public Enrollment(String username, String email, String password, Boolean enabled, Role role, Admin admin, Set<Student> registrations) {
        super(username, email, password, enabled, role);
        this.admin = admin;
        this.registrations = registrations;
    }
}
