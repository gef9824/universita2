package com.example.universita2.service;

import com.example.universita2.entity.Course;
import com.example.universita2.entity.Student;

import java.util.List;
import java.util.Set;

public interface CourseService {
    Course saveCourse(Course course);

    List<Course> getCourse();

    Course updateCourse(Long courseId, Course course);

    String deleteCourseById(Long courseId);

    Course addStudentToCourse(Long courseId, Long studentId);
    Course addTeacherToCourse(Long courseId, Long teacherId);


    Set<Student> trovaStudentiCorso(Long studentId);


    List<Course> getCourseOfStudent(Student student);

    Course getCourseById(Long courseId);

    Course updateCourseLight(Course existingCourse);
}
