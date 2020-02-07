package com.school.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import com.school.entities.StudentInput;
import com.school.repository.StudentRepository;
import com.school.entities.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
    @Autowired
    StudentRepository studentRepository;

//    public Student addStudent(String name, String email, String phone, TodoInput todoInput) {
//        return studentRepository.save(new Student(null, name, email, phone, todoInput.toTodo()));
//    }

    public Student addStudent(StudentInput studentInput) {
        return studentRepository.save(studentInput.toStudent());
    }
}
