package com.yegor.service;

import com.yegor.dao.CourseDAO;
import com.yegor.dao.CourseDAOImpl;
import com.yegor.dao.StudentDAO;
import com.yegor.dao.StudentDAOImpl;
import com.yegor.entities.CourseEntity;
import com.yegor.entities.StudentEntity;
import com.yegor.model.Course;
import com.yegor.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YegorKost on 11.03.2017.
 */
public class ServiceImpl implements Service {
    @Override
    public void addCourse(Course course) {
        CourseDAO courseDAO = new CourseDAOImpl();
        courseDAO.add(createCourseEntity(course));
    }

    @Override
    public void addStudent(Student student) {
        StudentDAO studentDAO = new StudentDAOImpl();
        studentDAO.add(createStudentEntity(student));
    }

    @Override
    public void updateCourse(Course course) {
        CourseDAO courseDAO = new CourseDAOImpl();
        courseDAO.update(createCourseEntity(course));
    }

    @Override
    public void updateStudent(Student student) {
        StudentDAO studentDAO = new StudentDAOImpl();
        studentDAO.update(createStudentEntity(student));
    }

    @Override
    public Course getCourse(Integer id) {
        CourseDAO courseDAO = new CourseDAOImpl();
        CourseEntity courseEntity = courseDAO.get(id);
        return createCourseBean(courseEntity);
    }

    @Override
    public Student getStudent(Integer id) {
        StudentDAO studentDAO = new StudentDAOImpl();
        StudentEntity studentEntity = studentDAO.get(id);
        return createStudentBean(studentEntity);
    }

    @Override
    public List<Course> getAllCourses() {
        CourseDAO courseDAO = new CourseDAOImpl();
        List<CourseEntity> courseList = courseDAO.getAll();
        List<Course> courses = new ArrayList<>();
        for (CourseEntity courseEntity: courseList) {
            courses.add(createCourseBean(courseEntity));
        }
        return courses;
    }

    @Override
    public List<Student> getAllStudents() {
        StudentDAO studentDAO = new StudentDAOImpl();
        List<StudentEntity> studentList = studentDAO.getAll();
        List<Student> students = new ArrayList<>();
        for (StudentEntity studentEntity: studentList) {
            students.add(createStudentBean(studentEntity));
        }
        return students;
    }

    @Override
    public void deleteCourse(Course course) {
        CourseDAO courseDAO = new CourseDAOImpl();
        courseDAO.delete(createCourseEntity(course));
    }

    @Override
    public void deleteStudent(Student student) {
        StudentDAO studentDAO = new StudentDAOImpl();
        studentDAO.delete(createStudentEntity(student));
    }

    private Course createCourseBean(CourseEntity courseEntity) {
        Course course = new Course();
        course.setId(courseEntity.getId());
        course.setName(courseEntity.getName());
        return course;
    }

    private Student createStudentBean(StudentEntity studentEntity) {
        Student student = new Student();
        student.setId(studentEntity.getId());
        student.setName(studentEntity.getName());
        student.setSurname(studentEntity.getSurname());
        student.setBirthday(studentEntity.getBirthday());
        student.setPhoneNumber(studentEntity.getPhoneNumber());
        student.setEmail(studentEntity.getEmail());
        student.setCourse(createCourseBean(studentEntity.getCourse()));
        return student;
    }

    private CourseEntity createCourseEntity(Course course) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setId(course.getId());
        courseEntity.setName(course.getName());
        return courseEntity;
    }

    private StudentEntity createStudentEntity(Student student) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(student.getId());
        studentEntity.setName(student.getName());
        studentEntity.setSurname(student.getSurname());
        studentEntity.setBirthday(student.getBirthday());
        studentEntity.setPhoneNumber(student.getPhoneNumber());
        studentEntity.setEmail(student.getEmail());
        studentEntity.setCourse(createCourseEntity(student.getCourse()));
        return studentEntity;
    }
}
