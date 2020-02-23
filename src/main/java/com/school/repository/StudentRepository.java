package com.school.repository;

import com.school.entities.Student;
import com.school.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    public List<Student> findByFullNameContains(@Param(value = "mc") String mc);

}
