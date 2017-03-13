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
 * Created by YegorKost on 13.03.2017.
 */

@WebServlet("/delUpStudent")
public class DelUpStudentServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("selectStudent.jsp");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action.equals("Update")) {

            Integer id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            LocalDate birthday = LocalDate.parse(request.getParameter("birthday"));
            String phoneNumber = request.getParameter("phoneNumber");
            String email = request.getParameter("email");
            Integer course = Integer.parseInt(request.getParameter("selectedCourse"));

            Service service = new ServiceImpl();

            Student student = new Student();
            student.setId(id);
            student.setName(name);
            student.setSurname(surname);
            student.setBirthday(birthday);
            student.setEmail(email);
            student.setPhoneNumber(phoneNumber);
            student.setCourse(service.getCourse(course));

            service.updateStudent(student);

            response.sendRedirect("student.jsp");

        } else if (action.equals("Delete")) {

            Service service = new ServiceImpl();
            Student student = service.getStudent(Integer.parseInt(request.getParameter("id")));

            service.deleteStudent(student);

            response.sendRedirect("student.jsp");
        }

    }

}
