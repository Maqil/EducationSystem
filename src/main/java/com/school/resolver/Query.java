package com.school.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.school.entities.Professor;
import com.school.entities.Todo;
import com.school.repository.ProfessorRepository;
import com.school.repository.StudentRepository;
import com.school.entities.Student;
import com.school.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {
    @Autowired
    ProfessorRepository professorRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TodoRepository todoRepository;

    //    Professor
    public List<Professor> fetchAllProfessors() {
        return professorRepository.findAll();
    }

    public Professor fetchProfessorById(Integer id) {
        return professorRepository.findById(id).get();
    }

    public List<Professor> fetchProfessorByName(String name) {
        return professorRepository.findByFullNameContains(name);
    }

    //    Student
    public List<Student> fetchAllStudents() {
        return studentRepository.findAll();
    }

    public Student fetchStudentById(Integer id) {
        return studentRepository.findById(id).get();
    }

    public List<Student> fetchStudentByName(String name) {
        return studentRepository.findByFullNameContains(name);
    }

    //    Todo
    public List<Todo> fetchAllTodos() {
        return todoRepository.findAll();
    }

    public Todo fetchTodoById(Integer id) {
        return todoRepository.findById(id).get();
    }
}
