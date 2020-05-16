package com.school.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
//import com.school.repository.EnrollmentRepository;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
//@NoArgsConstructor
@AllArgsConstructor
//@ToString
public class Enrollment extends User {

    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer enrollmentAiid;

//    @GeneratedValue(generator = "uuid")
//    @GenericGenerator(name = "uuid", strategy = "uuid2")
//    private String studentId;
//
//    private String fullName;
//    private String email;
//    private String phone;

    @OneToMany(mappedBy = "enrollment", fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Set<Student> registrations;

    @ManyToOne
    private Admin admin;

    public Enrollment() {

    }

    public Enrollment(String username, String password, String firstname, String lastname, String email, Boolean enabled, Role role) {
        super(username, password, firstname, lastname, email, enabled, role);
    }

    public Enrollment(String username, String password, String firstname, String lastname, String email, Boolean enabled, List<Role> roles) {
        super(username, password, firstname, lastname, email, enabled, roles);
    }

    public Enrollment(String username, String email, String password, Boolean enabled, Role role, Admin admin, Set<Student> registrations) {
        super(username, email, password, enabled, role);
        this.admin = admin;
        this.registrations = registrations;
    }
}
