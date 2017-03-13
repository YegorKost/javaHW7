package com.yegor.servlets;

import com.yegor.model.Student;
import com.yegor.service.Service;
import com.yegor.service.ServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by YegorKost on 13.03.2017.
 */
@WebServlet("/selectStudent")
public class SelectStudentServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Service service = new ServiceImpl();
        Student student = service.getStudent(Integer.parseInt(request.getParameter("selectedStudent")));
        request.setAttribute("selectedStudent", student);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("delUpStudent.jsp");
        requestDispatcher.forward(request, response);
    }
}
