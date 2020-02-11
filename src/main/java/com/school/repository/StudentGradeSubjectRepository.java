package com.school.repository;

import com.school.entities.StudentGradeSubject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentGradeSubjectRepository extends JpaRepository<StudentGradeSubject, Integer> {
}
