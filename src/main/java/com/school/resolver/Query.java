package com.school.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.school.repository.StudentRepository;
import com.school.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> fetchAllStudents() {
        return studentRepository.findAll();
    }

    public Student fetchStudentById(Integer id) {
        return studentRepository.findById(id).get();
    }

    public List<Student> fetchStudentByName(String name) {
        return studentRepository.findByFullNameContains(name);
    }
}
