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
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    AdminRepository adminRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    GradeRepository gradeRepository;
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    StudentGradeRepository studentGradeRepository;
    @Autowired
    ProfessorRepository professorRepository;
    @Autowired
    TodoRepository todoRepository;
    @Autowired
    AssignmentRepository assignmentRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Role r1 = roleRepository.save(new Role(RoleName.ROLE_ADMIN));
        Role r2 = roleRepository.save(new Role(RoleName.ROLE_USER));
        userRepository.save(new User("admin","admin","Sd1","sd","sd",true,r1));
        userRepository.save(new User("user","user","Sd2","sd","sd",true,r2));

        Admin admin = adminRepository.save(new Admin(null, "Dr1_Gr2", null, null, null, null));

//        Student s1 = studentRepository.save(new Student(null, "Ziyad Maqil", "Ziyad@gmail.com", "+212453445", null,admin));
//        Student s2 = studentRepository.save(new Student(null, "Wert Jelly", "Jelly@gmail.com", "+212233445", null,admin));
//        Student s3 = studentRepository.save(new Student(null, "bart Simpson", "simpson@gmail.com", "+212453445", null,admin));

        Student s1 = studentRepository.save(new Student(null, "Ziyad Maqil", "Ziyad@gmail.com", "+212453445", null, admin));
        Student s2 = studentRepository.save(new Student(null, "Wert Jelly", "Jelly@gmail.com", "+212233445", null, admin));
        Student s3 = studentRepository.save(new Student(null, "bart Simpson", "simpson@gmail.com", "+212453445", null, admin));

        Grade g1 = gradeRepository.save(new Grade(null, "CP", null, admin));
        Grade g2 = gradeRepository.save(new Grade(null, "CE1", null, admin));
        Grade g3 = gradeRepository.save(new Grade(null, "CE2", null, admin));

        Subject sbj1 = subjectRepository.save(new Subject(null, "Fr1", null, admin));
        Subject sbj2 = subjectRepository.save(new Subject(null, "Math1", null, admin));
        Subject sbj3 = subjectRepository.save(new Subject(null, "Bio1", null, admin));

        Set<Subject> listSbj = new HashSet<Subject>();
        listSbj.add(sbj1);
        listSbj.add(sbj2);
        listSbj.add(sbj3);

        StudentGrade stdGrd1 = studentGradeRepository.save(new StudentGrade(null, s1, g1, null));
        StudentGrade stdGrd2 = studentGradeRepository.save(new StudentGrade(null, s2, g1, null));
        StudentGrade stdGrd3 = studentGradeRepository.save(new StudentGrade(null, s3, g3, null));

        Set<StudentGrade> listStdGrd = new HashSet<StudentGrade>();
        listStdGrd.add(stdGrd1);
        listStdGrd.add(stdGrd2);
        listStdGrd.add(stdGrd3);

//        Enrollment enrollment1 = enrollmentRepository.save(new Enrollment(null, stdGrd1, sbj1, null));
//        Enrollment enrollment2 = enrollmentRepository.save(new Enrollment(null, stdGrd1, sbj2, null));
//        Enrollment enrollment3 = enrollmentRepository.save(new Enrollment(null, stdGrd2, sbj3, null));

        Professor p1 = professorRepository.save(new Professor(null, "Johna smith", "John@gmail.com", "+2125445", null, admin));
        Professor p2 = professorRepository.save(new Professor(null, "aicha curry", "curry@gmail.com", "+2125445", null, admin));
        Professor p3 = professorRepository.save(new Professor(null, "steve harr", "harr@gmail.com", "+2125445", null, admin));


        Todo t1 = todoRepository.save(new Todo(null, "Read 5 pages", p1, sbj1, null));
        Todo t2 = todoRepository.save(new Todo(null, "Read 6 pages", p2, sbj1, null));
        Todo t3 = todoRepository.save(new Todo(null, "Read 8 pages", p1, sbj3, null));
        Todo t4 = todoRepository.save(new Todo(null, "Read 5 pages", p1, sbj3, null));

        Set<Todo> listTodo = new HashSet<Todo>();
        listTodo.add(t1);
        listTodo.add(t2);
        listTodo.add(t3);
        listTodo.add(t4);

        Assignment assignment1 = assignmentRepository.save(new Assignment(null, stdGrd1, t1, true));
        Assignment assignment2 = assignmentRepository.save(new Assignment(null, stdGrd1, t2, true));
        Assignment assignment3 = assignmentRepository.save(new Assignment(null, stdGrd1, t3, true));
        Assignment assignment4 = assignmentRepository.save(new Assignment(null, stdGrd2, t4, true));
        Assignment assignment5 = assignmentRepository.save(new Assignment(null, stdGrd3, t4, false));


        System.out.println(p1.toString());
    }
}
