package com.school.entities;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentInput {
    private Integer studentAiid;
    private String fullName;
    private String email;
    private String phone;
    private Todo todos;

    public Student toStudent(){
        return Student.builder().studentAiid(this.studentAiid).fullName(this.fullName).email(this.email).phone(this.phone).todos(this.todos).build();
    }
}
