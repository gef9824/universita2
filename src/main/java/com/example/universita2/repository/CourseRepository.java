package com.example.universita2.repository;

import com.example.universita2.entity.Course;
import com.example.universita2.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

    //fornire l'elenco di tutti i corsi che segue uno studente,
    //@Query("SELECT s FROM Student s JOIN Course c WHERE s.studentId = ?1")


    List<Course> findByStudents(Student student);

    @Query("SELECT c.students FROM Course c WHERE c.courseId = ?1")
    Set<Student> trovaStudentiByIdCorso(Long id);

    @Query("SELECT c.teacher FROM Course c WHERE c.courseId = ?1")
    Set<Student> trovaDocenteByIdCorso(Long id);

    @Query("SELECT c FROM Course c WHERE c.courseId = ?1")
    Course trovaById(Long id);
}
