package com.school;

import com.school.entities.*;
import com.school.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

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
    ProfessorRepository professorRepository;
    @Autowired
    TodoRepository todoRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Student s1 = studentRepository.save(new Student(null, "Ziyad Maqil", "Ziyad@gmail.com", "+212453445", null));
        Student s2 = studentRepository.save(new Student(null, "Wert Jelly", "Jelly@gmail.com", "+212233445", null));
        Student s3 = studentRepository.save(new Student(null, "bart Simpson", "simpson@gmail.com", "+212453445", null));

        Grade g1 = gradeRepository.save(new Grade(null, null));
        Grade g2 = gradeRepository.save(new Grade(null, null));
        Grade g3 = gradeRepository.save(new Grade(null, null));

        StudentGrade stdGrd1 = studentGradeRepository.save(new StudentGrade(null, s1, g1, null));
        StudentGrade stdGrd2 = studentGradeRepository.save(new StudentGrade(null, s2, g1, null));
        StudentGrade stdGrd3 = studentGradeRepository.save(new StudentGrade(null, s3, g3, null));

        Set<StudentGrade> listStdGrd = new HashSet<StudentGrade>();
        listStdGrd.add(stdGrd1);
        listStdGrd.add(stdGrd2);
        listStdGrd.add(stdGrd3);

        Subject sbj1 = subjectRepository.save(new Subject(null, "Fr1", listStdGrd, null));
        Subject sbj2 = subjectRepository.save(new Subject(null, "Math1", listStdGrd, null));
        Subject sbj3 = subjectRepository.save(new Subject(null, "Bio1", listStdGrd, null));

        Set<Subject> listSbj = new HashSet<Subject>();
        listSbj.add(sbj1);
        listSbj.add(sbj2);
        listSbj.add(sbj3);

        Professor p1 = professorRepository.save(new Professor(null, "Johna smith", "John@gmail.com", "+2125445", listSbj, null));
        Professor p2 = professorRepository.save(new Professor(null, "aicha curry", "curry@gmail.com", "+2125445", listSbj, null));
        Professor p3 = professorRepository.save(new Professor(null, "steve harr", "harr@gmail.com", "+2125445", listSbj, null));

        Todo t1 = todoRepository.save(new Todo(null, "Read 5 pages", p1));
        Todo t2 = todoRepository.save(new Todo(null, "Read 6 pages", p2));
        Todo t3 = todoRepository.save(new Todo(null, "Read 8 pages", p1));
        Todo t4 = todoRepository.save(new Todo(null, "Read 5 pages", p1));

        Set<Todo> listTodo = new HashSet<Todo>();
        listTodo.add(t1);
        listTodo.add(t2);
        listTodo.add(t3);
        listTodo.add(t4);
        System.out.println(p1.toString());
    }
}
