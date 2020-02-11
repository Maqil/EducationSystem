package com.school.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.school.entities.*;
import com.school.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {
    @Autowired
    ProfessorRepository professorRepository;
    @Autowired
    TodoRepository todoRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    GradeRepository gradeRepository;
    @Autowired
    StudentGradeRepository studentGradeRepository;
    @Autowired
    SubjectRepository subjectRepository;

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

    //    Todo
    public List<Todo> fetchAllTodos() {
        return todoRepository.findAll();
    }

    public Todo fetchTodoById(Integer id) {
        return todoRepository.findById(id).get();
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

    //    Grade
    public List<Grade> fetchAllGrades() {
        return gradeRepository.findAll();
    }

    public Grade fetchGradeById(Integer id) {
        return gradeRepository.findById(id).get();
    }

    //    StudentGrade
    public List<StudentGrade> fetchAllStudentGrades() {
        return studentGradeRepository.findAll();
    }

    public StudentGrade fetchStudentGradeById(Integer id) {
        return studentGradeRepository.findById(id).get();
    }

    //    Subject
    public List<Subject> fetchAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject fetchSubjectById(Integer id) {
        return subjectRepository.findById(id).get();
    }

    public List<Subject> fetchSubjectByName(String name) {
        return subjectRepository.findBySubjectNameContains(name);
    }


}
