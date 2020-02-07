package com.school.entities;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoInput {

    private Integer todoAiid;
    private String description;
    private Professor professor;

    public Todo toTodo(){
        return Todo.builder().todoAiid(this.todoAiid).description(this.description).professor(this.professor).build();
    }
}
