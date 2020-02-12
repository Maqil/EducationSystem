package com.school.graphqlInput;

import com.school.entities.Grade;
import com.school.entities.Student;
import com.school.entities.Todo;
import lombok.*;

import java.util.Collection;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GradeInput {
    private String gradeName;

    public Grade toGrade(){
        return Grade.builder().gradeName(this.gradeName).build();
    }
}
