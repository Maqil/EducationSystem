package com.school.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import com.school.entities.*;
import com.school.graphqlInput.*;
import com.school.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
    @Autowired
    ProfessorRepository professorRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    GradeRepository gradeRepository;
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    TodoRepository todoRepository;

    public Professor addProfessor(ProfessorInput professorInput) {
        return professorRepository.save(professorInput.toProfessor());
    }

    public Student addStudent(StudentInput studentInput) {
        return studentRepository.save(studentInput.toStudent());
    }

    public Grade addGrade(GradeInput gradeInput) {
        return gradeRepository.save(gradeInput.toGrade());
    }

    public Subject addSubject(SubjectInput subjectInput) {
        return subjectRepository.save(subjectInput.toSubject());
    }

    public Todo addTodo(TodoInput todoInput) {
        return todoRepository.save(todoInput.toTodo());
    }
}
