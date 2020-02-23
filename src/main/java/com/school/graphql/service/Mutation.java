package com.school.graphql.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.entities.*;
import com.school.repository.*;
import com.school.security.jwt.JwtTokenUtil;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class Mutation {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private StudentRepository studentRepository;
    private ProfessorRepository professorRepository;
    private SubjectRepository subjectRepository;
    private TodoRepository todoRepository;
    private GradeRepository gradeRepository;

    public Mutation(StudentRepository studentRepository, ProfessorRepository professorRepository, SubjectRepository subjectRepository, TodoRepository todoRepository, GradeRepository gradeRepository) {
        this.studentRepository = studentRepository;
        this.professorRepository = professorRepository;
        this.gradeRepository = gradeRepository;
        this.subjectRepository = subjectRepository;
        this.todoRepository = todoRepository;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GraphQLMutation(name = "addStudent")
    public Student addStudent(@GraphQLArgument(name = "student") Student student) {
        return studentRepository.save(student);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GraphQLMutation(name = "addProfessor")
    public Professor addProfessor(@GraphQLArgument(name = "professor") Professor professor) {
        return professorRepository.save(professor);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GraphQLMutation(name = "addGrade")
    public Grade addGrade(@GraphQLArgument(name = "grade") Grade grade) {
        return gradeRepository.save(grade);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GraphQLMutation(name = "addSubject")
    public Subject addSubject(@GraphQLArgument(name = "subject") Subject subject) {
        return subjectRepository.save(subject);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GraphQLMutation(name = "addTodo")
    public Todo addTodo(@GraphQLArgument(name = "todo") Todo todo) {
        return todoRepository.save(todo);
    }
}
