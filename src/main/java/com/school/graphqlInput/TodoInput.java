package com.school.graphqlInput;

import com.school.entities.Professor;
import com.school.entities.Student;
import com.school.entities.Subject;
import com.school.entities.Todo;
import lombok.*;

import java.util.Collection;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoInput {

    private Integer todoAiid;
    private String description;
    private Professor professor;
    private Subject subject;

    public Todo toTodo(){
        return Todo.builder().todoAiid(this.todoAiid).description(this.description).professor(this.professor).subject(this.subject).build();
    }
}
