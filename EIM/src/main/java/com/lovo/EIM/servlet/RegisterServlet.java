package com.lovo.EIM.servlet;

import com.lovo.EIM.bean.User;
import com.lovo.EIM.service.UserService;
import com.lovo.EIM.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Controller
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

//    @Resource(name = "userService")
    UserService us = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        user.setEmail(email);

        boolean register = us.register(user);

        if (register) {
            response.getWriter().println("注册成功！<br/><a href='index.jsp'>点击开始登录</a>");
        } else {
            response.sendRedirect("jsp/register.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
