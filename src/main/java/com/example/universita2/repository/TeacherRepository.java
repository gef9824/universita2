package com.example.universita2.repository;

import com.example.universita2.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    Teacher findByTeacherNameIgnoreCase(String teacherName);


}
