package com.example.universita2.service;

import com.example.universita2.entity.Course;
import com.example.universita2.entity.Student;
import com.example.universita2.entity.Teacher;
import com.example.universita2.repository.CourseRepository;
import com.example.universita2.repository.StudentRepository;
import com.example.universita2.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class ServiceImpl implements StudentService,TeacherService,CourseService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Student saveStudents(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).get();
    }

    @Override
    public String deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
        return "Student Deleted";
    }

    @Override
    public Student updateStudent(Long studentId, Student student) {
        Student studentDB = studentRepository.findById(studentId).get();
        if (Objects.nonNull(student.getMatricola()) && !"".equalsIgnoreCase(student.getMatricola())) {
            studentDB.setMatricola(student.getMatricola());
        }
        if (Objects.nonNull(student.getStudentName()) && !"".equalsIgnoreCase(student.getStudentName())) {
            studentDB.setStudentName(student.getStudentName());
        }
        if (Objects.nonNull(student.getStudentSurname()) && !"".equalsIgnoreCase(student.getStudentSurname())) {
            studentDB.setStudentSurname(student.getStudentSurname());
        }


        return studentRepository.save(studentDB);
    }

    @Override
    public Student getStudentByName(String studentName) {
        return studentRepository.findByStudentNameIgnoreCase(studentName);
    }

    @Override
    public Student updateStudentLight(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Teacher updateTeacherLight(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> getTeacher() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacherById(Long teacherId) {
        return teacherRepository.findById(teacherId).get();
    }

    @Override
    public Teacher getTeacherByName(String teacherName) {
        return teacherRepository.findByTeacherNameIgnoreCase(teacherName);
    }

    @Override
    public String deleteTeacherById(Long teacherId) {
        teacherRepository.deleteById(teacherId);
        return "Teacher deleted";
    }

    @Override
    public Teacher updateTeacher(Long teacherId, Teacher teacher) {
        Teacher teacherDB = teacherRepository.findById(teacherId).get();
        if (Objects.nonNull(teacher.getTeacherName()) && !"".equalsIgnoreCase(teacher.getTeacherName()))
            teacherDB.setTeacherName(teacher.getTeacherName());
        if (Objects.nonNull(teacher.getTeacherSurname()) && !"".equalsIgnoreCase(teacher.getTeacherSurname()))
            teacherDB.setTeacherSurname(teacher.getTeacherSurname());
        return teacherRepository.save(teacherDB);
    }


    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getCourse() {
        return courseRepository.findAll();
    }

    @Override
    public Course updateCourse(Long courseId, Course course) {
        Course courseDB = courseRepository.findById(courseId).get();
        if (Objects.nonNull(course.getCourseName()) && !"".equalsIgnoreCase(course.getCourseName())) {
            courseDB.setCourseName(course.getCourseName());
        }
        return courseRepository.save(courseDB);
    }

    @Override
    public String deleteCourseById(Long courseId) {
        courseRepository.deleteById(courseId);
        return "Course Deleted";
    }

    //Update student with path variable
    @Override
    public Course addStudentToCourse(Long courseId, Long studentId) {
        Course corsoDB = courseRepository.trovaById(courseId);
        Set<Student> courseStudents = corsoDB.getStudents();
        courseStudents.add(studentRepository.findById(studentId).get());
        corsoDB.setStudents(courseStudents);
        return courseRepository.save(corsoDB);
    }

    @Override
    public Course addTeacherToCourse(Long courseId, Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId).get();
        Course corsoDB = courseRepository.trovaById(courseId);
        corsoDB.setTeacher(teacher);
        return courseRepository.save(corsoDB);
    }

    @Override
    public Set<Student> trovaStudentiCorso(Long courseId) {
        return courseRepository.trovaStudentiByIdCorso(courseId);
    }

    @Override
    public List<Course> getCourseOfStudent(Student student) {
        return courseRepository.findByStudents(student);
    }

    @Override
    public Course getCourseById(Long courseId) {
        return courseRepository.findById(courseId).get();
    }

    @Override
    public Course updateCourseLight(Course existingCourse) {
        return courseRepository.save(existingCourse);
    }


}
