package com.lovo.EntInfoMan.servlet;

import com.lovo.EntInfoMan.bean.Address;
import com.lovo.EntInfoMan.service.IAddressService;
import com.lovo.EntInfoMan.service.impl.AddressServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddAddressServlet")
public class AddAddressServlet extends HttpServlet {

    IAddressService as = new AddressServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        String qq = request.getParameter("qq");
        String company = request.getParameter("company");
        String address = request.getParameter("address");
        int postcode = Integer.valueOf(request.getParameter("postcode"));

        Address a = new Address(0, name, sex, mobile, email, qq, company, address, postcode);

        response.getWriter().println("success:" + as.add(a));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
