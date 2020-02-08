package com.school.graphqlInput;

import com.school.entities.Student;
import com.school.entities.Todo;
import lombok.*;

import java.util.Collection;

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
    private Collection<Todo> todos;

    public Student toStudent(){
        return Student.builder().studentAiid(this.studentAiid).fullName(this.fullName).email(this.email).phone(this.phone).todos(this.todos).build();
    }
}
