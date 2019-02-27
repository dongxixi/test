package com.lovo.EntInfoMan.servlet;

import com.lovo.EntInfoMan.bean.User;
import com.lovo.EntInfoMan.service.IUserService;
import com.lovo.EntInfoMan.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    IUserService us = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);

        boolean login = us.login(user);

        if (login) {
            response.sendRedirect("jsp/main.jsp");
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}
