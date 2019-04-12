package com.lovo.EIM.servlet;

import com.lovo.EIM.bean.User;
import com.lovo.EIM.service.UserService;
import com.lovo.EIM.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@Controller
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

//    @Resource(name = "userService")
    UserService us = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        String config = "applicationContext.xml";
//        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
//        us = (UserService) ctx.getBean("userService");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);

        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(60 * 60);

        boolean login = us.login(user);

        if (login) {
            session.setAttribute("login", user);

            response.sendRedirect("jsp/main.jsp");
        } else {
            response.sendRedirect("index.jsp");
        }


    }
}
