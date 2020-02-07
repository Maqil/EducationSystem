package com.school.entities;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentAiid;
    private String fullName;
    private String email;
    private String phone;
    @ManyToOne
    private Todo todos;
}
