package com.lovo.MavenTest.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/colaspanServlet")
public class colaspanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        Double firstnum = Double.valueOf(request.getParameter("firstnum"));
        Double secondnum = Double.valueOf(request.getParameter("secondnum"));
        String operator = request.getParameter("operator");
        Double result = 0d;
        switch (operator) {
            case "+":
                result = firstnum + secondnum;
                break;
            case "-":
                result = firstnum - secondnum;
                break;
            case "*":
                result = firstnum * secondnum;
                break;
            case "/":
                result = firstnum / secondnum;
                break;
        }

//        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(getServletContext().getRealPath("data.txt"))));
//
//        out.write("" + result);
//        out.close();
//        response.sendRedirect("login.jsp");

        request.setAttribute("result", result);
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
