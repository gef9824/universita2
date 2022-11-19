package com.example.universita2.controller;

import com.example.universita2.entity.Student;
import com.example.universita2.entity.Teacher;
import com.example.universita2.repository.TeacherRepository;
import com.example.universita2.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @PostMapping("/teachers")
    public Teacher saveTeacher(@RequestBody Teacher teacher){
        return teacherService.saveTeacher(teacher);
    }
    @GetMapping("/teachers")
    public List<Teacher> getTeacher(){
        return teacherService.getTeacher();
    }
    @GetMapping("/teachers/{id}")
    public Teacher getTeacherById(@PathVariable("id") Long teacherId){
        return teacherService.getTeacherById(teacherId);
    }
    @GetMapping("/teachers/name/{name}")
    public Teacher getTeacherByName(@PathVariable("name") String teacherName){
        return teacherService.getTeacherByName(teacherName);
    }
    @DeleteMapping("/teachers/{id}")
    public String deleteTeacherById(@PathVariable("id") Long teacherId){
        return teacherService.deleteTeacherById(teacherId);
    }
    @PutMapping("/teachers/{id}")
    public Teacher updateTeacher(@PathVariable("id") Long teacherId, @RequestBody Teacher teacher){
        return teacherService.updateTeacher(teacherId,teacher);
    }

}
