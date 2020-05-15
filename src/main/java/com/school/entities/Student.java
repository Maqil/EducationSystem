package com.school.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
//import com.school.repository.StudentRepository;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
//@NoArgsConstructor
@AllArgsConstructor
//@ToString
public class Student extends User {

    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentAiid;

//    @GeneratedValue(generator = "uuid")
//    @GenericGenerator(name = "uuid", strategy = "uuid2")
//    private String studentId;
//
//    private String fullName;
//    private String email;
//    private String phone;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Set<StudentGrade> registrations;

    @ManyToOne
    private Admin admin;

    public Student() {
        System.out.println("C0");
    }

    public Student(String username, String password, String firstname, String lastname, String email, Boolean enabled, Role role) {
        super(username, password, firstname, lastname, email, enabled, role);
        System.out.println("C1");
    }

    public Student(String username, String password, String firstname, String lastname, String email, Boolean enabled, List<Role> roles) {
        super(username, password, firstname, lastname, email, enabled, roles);
        System.out.println("C2");
    }

    public Student(String username, String email, String password, Boolean enabled, Role role, Admin admin, Set<StudentGrade> registrations) {
        super(username, email, password, enabled, role);
        this.admin = admin;
        this.registrations = registrations;
        System.out.println("C3");
    }
}
