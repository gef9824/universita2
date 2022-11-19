package com.example.universita2.service;

import com.example.universita2.entity.Student;
import com.example.universita2.entity.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher saveTeacher(Teacher teacher);

    List<Teacher> getTeacher();

    Teacher getTeacherById(Long teacherId);


    Teacher getTeacherByName(String teacherName);

    String deleteTeacherById(Long teacherId);

    Teacher updateTeacher(Long teacherId, Teacher teacher);

    Teacher updateTeacherLight(Teacher teacher);
}
