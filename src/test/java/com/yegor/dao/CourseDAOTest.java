package com.yegor.dao;

import com.yegor.entities.CourseEntity;
import com.yegor.entities.StudentEntity;
import org.junit.*;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by YegorKost on 08.03.2017.
 */
public class CourseDAOTest {

    private static CourseEntity c1, c2;
    private static StudentEntity s1, s2;
    private CourseDAO courseDAO = new CourseDAO();
    private StudentDAO studentDAO = new StudentDAO();

    @BeforeClass
    public static void initDB() {
        TestedDB.initDb();

        c1 = new CourseEntity();
        c1.setId(1);
        c1.setName("Java");

        c2 = new CourseEntity();
        c2.setId(2);
        c2.setName("Python");

        s1 = new StudentEntity();
        s1.setId(1);
        s1.setName("Bob");
        s1.setSurname("Dilan");
        s1.setPhoneNumber("1234567891");
        s1.setBirthday(LocalDate.of(1980, 3, 1));
        s1.setEmail("dilan@gmail.com");

        s2 = new StudentEntity();
        s2.setId(2);
        s2.setName("Rok");
        s2.setSurname("Hook");
        s2.setPhoneNumber("7777777777");
        s2.setBirthday(LocalDate.of(1982, 4, 3));
        s2.setEmail("hook@gmail.com");
    }

    @AfterClass
    public static void deleteDB() {
        TestedDB.deleteDB();
    }

    @Before
    public void setDBData() {
        TestedDB.setDBData(c1, c2, s1, s2);
    }

    @After
    public void cleanDBData() {
        TestedDB.cleanDBData();
    }

    @Test
    public void addTest() throws Exception {
        CourseEntity courseNew = new CourseEntity();
        courseNew.setName("Scala");
        courseDAO.add(courseNew);
        assertEquals(courseNew, courseDAO.get(3));
    }

    @Test
    public void getTest() throws Exception {
        CourseEntity courseEntity = courseDAO.get(1);
        assertEquals(c1, courseEntity);
        assertTrue(courseEntity.getStudents().contains(s1));
        assertTrue(courseEntity.getStudents().contains(s2));
    }

    @Test
    public void getAllCourseTest() throws Exception {
        List<CourseEntity> courses = courseDAO.getAll();
        assertTrue(courses.contains(c1));
        assertTrue(courses.contains(c2));
    }

    @Test
    public void updateTest() throws Exception {
        CourseEntity courseUpdate = courseDAO.get(2);
        courseUpdate.setName("Python-1");
        courseDAO.update(courseUpdate);
        assertEquals("Python-1", courseDAO.get(2).getName());
    }

    @Test
    public void deleteTest() throws Exception {
        CourseEntity courseDel = courseDAO.get(2);
        assertEquals(c2, courseDel);
        courseDAO.delete(courseDel);
        assertEquals(null, courseDAO.get(2));
    }

//    @Test
//    public void deleteTest1() throws Exception {
//        CourseEntity courseDel = courseDAO.get(1);
//        assertEquals(c1, courseDel);
//        courseDAO.delete(courseDel);
//    }

    @Test
    public void addStudentTest() throws Exception {
        CourseEntity course = courseDAO.get(1);
        StudentEntity addedStudent = new StudentEntity();
        addedStudent.setName("Fold");
        addedStudent.setSurname("Polo");
        addedStudent.setCourse(course);
        studentDAO.add(addedStudent);
        assertEquals(addedStudent, studentDAO.get(3));
        assertEquals(course, studentDAO.get(3).getCourse());
    }

    @Test
    public void getStudentTest() throws Exception {
        StudentEntity gottenStudent = studentDAO.get(1);
        assertEquals(s1, gottenStudent);
        assertEquals(c1, gottenStudent.getCourse());
    }

    @Test
    public void getAllStudentTest() throws Exception {
//        List<StudentEntity> students = studentDAO.getAll();
        assertTrue(studentDAO.getAll().contains(s1));
//        assertTrue(students.contains(s2));
    }

    @Test
    public void updateStudentTest() throws Exception {
        StudentEntity studentUpdate = studentDAO.get(1);
        studentUpdate.setPhoneNumber("8888888888");
        studentDAO.update(studentUpdate);
        assertEquals("8888888888", studentDAO.get(1).getPhoneNumber());
    }

    @Test
    public void deleteStudentTest() throws Exception {
        StudentEntity studentDel = studentDAO.get(1);
        assertEquals(s1, studentDel);
        studentDAO.delete(studentDel);
        assertEquals(null, studentDAO.get(1));
    }

}