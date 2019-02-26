package com.lovo.MavenTest.servlet;

import com.lovo.MavenTest.Service.IStudentService;
import com.lovo.MavenTest.Service.impl.StudentServiceImpl;
import com.lovo.MavenTest.bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ShowUserServlet")
public class ShowUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        IStudentService ss = new StudentServiceImpl();
        List<Student> list = ss.getlist(null, 1, 99);

        StringBuffer str = new StringBuffer();
        str.append("{list:[");
        for (Student s : list) {
            str.append("{id:");
            str.append(s.getId());
            str.append(",name:\"");
            str.append(s.getName());
            str.append("\",grade:\"");
            str.append(s.getGrade());
            str.append("\",sex:\"");
            str.append(s.getSex());
            str.append("\",age:");
            str.append(s.getAge());
            str.append(",score:");
            str.append(s.getScore());
            str.append("},");
        }
        str.substring(0, str.length() - 1);
        System.out.println(str.toString());
        str.append("]}");

        out.println(str.toString());
    }
}
