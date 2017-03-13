package com.yegor.service;

import com.yegor.model.Course;
import com.yegor.model.Student;

import java.util.List;

/**
 * Created by YegorKost on 11.03.2017.
 */
public interface Service {

    void addCourse(Course course);
    void addStudent(Student student);
    void updateCourse(Course course);
    void updateStudent(Student student);
    Course getCourse(Integer id);
    Student getStudent(Integer id);
    List<Course> getAllCourses();
    List<Student> getAllStudents();
    void deleteCourse(Course course);
    void deleteStudent(Student student);

}
