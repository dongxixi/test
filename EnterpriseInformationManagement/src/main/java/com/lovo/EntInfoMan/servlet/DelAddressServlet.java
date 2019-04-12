package com.lovo.EntInfoMan.servlet;

import com.lovo.EntInfoMan.service.AddressService;
import com.lovo.EntInfoMan.service.impl.AddressServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DelAddressServlet")
public class DelAddressServlet extends HttpServlet {

    AddressService as = new AddressServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.valueOf(request.getParameter("id"));

        response.getWriter().println("success:" + as.del(id));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
