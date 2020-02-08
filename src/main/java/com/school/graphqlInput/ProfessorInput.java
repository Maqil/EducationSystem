package com.school.graphqlInput;

import com.school.entities.Professor;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorInput {
    private Integer professorAiid;
    private String fullName;
    private String email;
    private String phone;

    public Professor toProfessor(){
        return Professor.builder().professorAiid(this.professorAiid).fullName(this.fullName).email(this.email).phone(this.phone).build();
    }

}
