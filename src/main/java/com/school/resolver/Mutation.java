package com.school.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import com.school.entities.Grade;
import com.school.entities.Professor;
import com.school.entities.Todo;
import com.school.graphqlInput.GradeInput;
import com.school.graphqlInput.ProfessorInput;
import com.school.graphqlInput.StudentInput;
import com.school.graphqlInput.TodoInput;
import com.school.repository.GradeRepository;
import com.school.repository.ProfessorRepository;
import com.school.repository.StudentRepository;
import com.school.entities.Student;

import com.school.repository.TodoRepository;
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

    public Todo addTodo(TodoInput todoInput) {
        return todoRepository.save(todoInput.toTodo());
    }
}
