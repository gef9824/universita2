package com.example.universita2.controller;

import com.example.universita2.entity.Course;
import com.example.universita2.entity.Student;
import com.example.universita2.entity.Teacher;
import com.example.universita2.service.CourseService;
import com.example.universita2.service.StudentService;
import com.example.universita2.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
public class WebController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private CourseService courseService;



    @GetMapping("/s")
    public String listStudents(Model model){
        model.addAttribute("students",studentService.getStudents());
        return "students";
    }
    @GetMapping("/t")
    public String listTeachers(Model model){
        model.addAttribute("teachers",teacherService.getTeacher());
        return "teachers";
    }
    @GetMapping("/c")
    public String listCourses(Model model){
        model.addAttribute("courses",courseService.getCourse());
        return "courses";
    }



    @GetMapping("/s/new")
    public String createStudent(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        return "create_student";
    }
    @GetMapping("/t/new")
    public String createTeacher(Model model){
        Teacher teacher = new Teacher();
        model.addAttribute("teacher",teacher);
        return "create_teacher";
    }
    @GetMapping("/c/new")
    public String createCourse(Model model){
        Course course = new Course();
        model.addAttribute("course",course);
        return "create_course";
    }



    @PostMapping("/s")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudents(student);
        return "redirect:/s";
    }
    @PostMapping("/t")
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher){
        teacherService.saveTeacher(teacher);
        return "redirect:/t";
    }
    @PostMapping("/c")
    public String saveCourse(@ModelAttribute("course") Course course){
        courseService.saveCourse(course);
        return "redirect:/c";
    }



    @GetMapping("/s/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model){
        model.addAttribute("student",studentService.getStudentById(id));
        return "edit_student";
    }
    @GetMapping("/t/edit/{id}")
    public String editTeacherForm(@PathVariable Long id, Model model){
        model.addAttribute("teacher",teacherService.getTeacherById(id));
        return "edit_teacher";
    }
    @GetMapping("/c/edit/{id}")
    public String editCourseForm(@PathVariable Long id, Model model){
        model.addAttribute("course",courseService.getCourseById(id));
        return "edit_course";
    }



    @PostMapping("/s/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model){
        //get student from DB by id
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setStudentId(id);
        existingStudent.setStudentName(student.getStudentName());
        existingStudent.setStudentSurname(student.getStudentSurname());
        existingStudent.setMatricola(student.getMatricola());
        //saving
        studentService.updateStudentLight(existingStudent);
        return "redirect:/s";
    }
    @PostMapping("/t/{id}")
    public String updateTeacher(@PathVariable Long id, @ModelAttribute("teacher") Teacher teacher, Model model){
        //get student from DB by id
        Teacher existingTeacher = teacherService.getTeacherById(id);
        existingTeacher.setTeacherId(id);
        existingTeacher.setTeacherName(teacher.getTeacherName());
        existingTeacher.setTeacherSurname(teacher.getTeacherSurname());
        //saving
        teacherService.updateTeacherLight(existingTeacher);
        return "redirect:/t";
    }
    @PostMapping("/c/{id}")
    public String updateCourse(@PathVariable Long id, @ModelAttribute("course") Course course, Model model){
        //get student from DB by id
        Course existingCourse = courseService.getCourseById(id);
        //List<Student> students = studentService.getStudents();
        existingCourse.setCourseId(id);
        existingCourse.setCourseName(course.getCourseName());
        //existingCourse.setStudents((Set<Student>) students);
        //saving
        courseService.updateCourseLight(existingCourse);

        return "redirect:/c";
    }


    @GetMapping("/s/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return "redirect:/s";
    }
    @GetMapping("/t/{id}")
    public String deleteTeacher(@PathVariable Long id){
        teacherService.deleteTeacherById(id);
        return "redirect:/t";
    }
    @GetMapping("/c/{id}")
    public String deleteCourse(@PathVariable Long id){
        courseService.deleteCourseById(id);
        return "redirect:/c";
    }

}
