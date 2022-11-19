package com.example.universita2.service;

import com.example.universita2.entity.Student;
import com.example.universita2.entity.Teacher;

import java.util.List;

public interface StudentService {
    Student saveStudents(Student student);

    List<Student> getStudents();

    Student getStudentById(Long studentId);

    String deleteStudentById(Long studentId);

    Student updateStudent(Long studentId, Student student);

    Student getStudentByName(String studentName);

    Student updateStudentLight(Student student);


}
