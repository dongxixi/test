package com.lovo.EIM.servlet;

import com.lovo.EIM.service.AddressService;
import com.lovo.EIM.service.impl.AddressServiceImpl;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Controller
@WebServlet("/DelAddressServlet")
public class DelAddressServlet extends HttpServlet {

//    @Resource(name = "addressService")
    AddressService as = new AddressServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.valueOf(request.getParameter("id"));

        response.getWriter().println("success:" + as.del(id));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
