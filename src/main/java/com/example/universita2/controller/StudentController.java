package com.example.universita2.controller;

import com.example.universita2.entity.Student;
import com.example.universita2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public Student saveStudents(@RequestBody Student student){
        return studentService.saveStudents(student);
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable("id") Long studentId){
        return studentService.getStudentById(studentId);
    }

    @GetMapping("/student/name/{name}")
    public Student getStudentByName(@PathVariable("name") String studentName){
        return studentService.getStudentByName(studentName);
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudentById(@PathVariable("id") Long studentId){
        return studentService.deleteStudentById(studentId);
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable("id") Long studentId, @RequestBody Student student){
        return studentService.updateStudent(studentId,student);
    }

}
