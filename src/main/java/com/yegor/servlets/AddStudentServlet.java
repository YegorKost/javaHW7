package com.yegor.servlets;

import com.yegor.model.Student;
import com.yegor.service.Service;
import com.yegor.service.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Created by YegorKost on 12.03.2017.
 */
@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.sendRedirect("addStudents.jsp");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        LocalDate birthday = LocalDate.parse(request.getParameter("birthday"));
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String course = request.getParameter("selectedCourse");

        Service service = new ServiceImpl();

        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setBirthday(birthday);
        student.setEmail(email);
        student.setPhoneNumber(phoneNumber);
        student.setCourse(service.getCourse(Integer.parseInt(course)));

        service.addStudent(student);

        response.sendRedirect("student.jsp");

    }

}
