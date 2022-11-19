package com.example.universita2.controller;

import com.example.universita2.entity.Course;
import com.example.universita2.entity.Student;
import com.example.universita2.repository.CourseRepository;
import com.example.universita2.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@RestController
@RequestMapping("/")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/course")
    public Course saveCourse(@RequestBody Course course){
        return courseService.saveCourse(course);
    }

    @GetMapping("/course")
    public List<Course> getCourse(){
        return courseService.getCourse();
    }

    @DeleteMapping("/course/{id}")
    public String deleteCourseById(@PathVariable("id") Long courseId){
        return courseService.deleteCourseById(courseId);
    }

    @PutMapping("/course/{id}")
    public Course updateCourse(@PathVariable("id") Long courseId, @RequestBody Course course){
        return courseService.updateCourse(courseId,course);
    }

    @PutMapping(path = "/course/{courseId}/addStudent/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Course addStudentToCourse(@PathVariable("courseId") Long courseId, @PathVariable("studentId") Long studentId){
        return courseService.addStudentToCourse(courseId,studentId);
    }
    @PutMapping(path = "/course/{courseId}/addTeacher/{teacherId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Course addTeacherToCourse(@PathVariable("courseId") Long courseId, @PathVariable("teacherId") Long teacherId){
        Course course = courseService.getCourseById(courseId);
        if(Objects.nonNull(course.getTeacher()))
            return null;
        else
        return courseService.addTeacherToCourse(courseId,teacherId);
    }

    @GetMapping(path = "/course/selectCourse/{courseId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<Student> trovaStudentiCorso(@PathVariable("courseId") Long courseId){
        return courseService.trovaStudentiCorso(courseId);
    }

    @GetMapping(path = "/course/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> getCourseOfStudent(@PathVariable("studentId") Student student){
        return courseService.getCourseOfStudent(student);
    }

}
