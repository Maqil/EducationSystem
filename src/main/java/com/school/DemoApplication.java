package com.school;

import com.school.entities.*;
import com.school.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    GradeRepository gradeRepository;
    @Autowired
    StudentGradeRepository studentGradeRepository;
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    StudentGradeSubjectRepository studentGradeSubjectRepository;
    @Autowired
    StdGrdSbjTdRepository stdGrdSbjTdRepository;
    @Autowired
    ProfessorRepository professorRepository;
    @Autowired
    TodoRepository todoRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Professor p1 = professorRepository.save(new Professor(null, "John smith", "John@gmail.com", "+2125445", null));
        Professor p2 = professorRepository.save(new Professor(null, "aicha curry", "curry@gmail.com", "+2125445", null));
        Professor p3 = professorRepository.save(new Professor(null, "steve harr", "harr@gmail.com", "+2125445", null));

        Student s1 = studentRepository.save(new Student(null, "Ziyad Maqil", "Ziyad@gmail.com", "+212453445", null));
        Student s2 = studentRepository.save(new Student(null, "Wert Jelly", "Jelly@gmail.com", "+212233445", null));
        Student s3 = studentRepository.save(new Student(null, "bart Simpson", "simpson@gmail.com", "+212453445", null));

        Grade g1 = gradeRepository.save(new Grade(null, null));
        Grade g2 = gradeRepository.save(new Grade(null, null));
        Grade g3 = gradeRepository.save(new Grade(null, null));

        StudentGrade stdGrd1 = studentGradeRepository.save(new StudentGrade(null, s1, g1, null));
        StudentGrade stdGrd2 = studentGradeRepository.save(new StudentGrade(null, s2, g1, null));
        StudentGrade stdGrd3 = studentGradeRepository.save(new StudentGrade(null, s3, g3, null));

        Subject sbj1 = subjectRepository.save(new Subject(null, "Fr1", null));
        Subject sbj2 = subjectRepository.save(new Subject(null, "Math1", null));
        Subject sbj3 = subjectRepository.save(new Subject(null, "Bio1", null));

        StudentGradeSubject stdGrdSbj1 = studentGradeSubjectRepository.save(new StudentGradeSubject(null, stdGrd1, sbj1, null));
        StudentGradeSubject stdGrdSbj2 = studentGradeSubjectRepository.save(new StudentGradeSubject(null, stdGrd1, sbj1, null));
        StudentGradeSubject stdGrdSbj3 = studentGradeSubjectRepository.save(new StudentGradeSubject(null, stdGrd1, sbj1, null));

        Todo t1 = todoRepository.save(new Todo(null, "Read 5 pages", p1, null));
        Todo t2 = todoRepository.save(new Todo(null, "Read 6 pages", p2, null));
        Todo t3 = todoRepository.save(new Todo(null, "Read 8 pages", p3, null));
        Todo t4 = todoRepository.save(new Todo(null, "Read 5 pages", p1, null));

        StdGrdSbjTd stdGrdSbjTd1 = stdGrdSbjTdRepository.save(new StdGrdSbjTd(null, t1, stdGrdSbj1));
        StdGrdSbjTd stdGrdSbjTd2 = stdGrdSbjTdRepository.save(new StdGrdSbjTd(null, t2, stdGrdSbj1));
        StdGrdSbjTd stdGrdSbjTd3 = stdGrdSbjTdRepository.save(new StdGrdSbjTd(null, t1, stdGrdSbj1));

    }
}
