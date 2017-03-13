package com.yegor.filters;

import com.yegor.model.Course;
import com.yegor.model.Student;
import com.yegor.service.Service;
import com.yegor.service.ServiceImpl;
import com.yegor.util.HibernateUtil;
import org.hibernate.SessionFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by YegorKost on 13.03.2017.
 */
@WebFilter(urlPatterns = {"/*"})
public class CharSetFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        Service service = new ServiceImpl();

        List<Course> listCourse = service.getAllCourses();
        request.getSession().setAttribute("courseList", listCourse);

        List<Student> listStudent = service.getAllStudents();
        request.getSession().setAttribute("studentList", listStudent);

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        HibernateUtil.getSessionFactory().close();
    }
}
