package com.school.graphqlInput;

import com.school.entities.Professor;
import com.school.entities.Subject;
import com.school.entities.Todo;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubjectInput {
    private Integer subjectAiid;
    private String subjectName;

    public Subject toSubject(){
        return Subject.builder().subjectAiid(this.subjectAiid).subjectName(this.subjectName).build();
    }
}
