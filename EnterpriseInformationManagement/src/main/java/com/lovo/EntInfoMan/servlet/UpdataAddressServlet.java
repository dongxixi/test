package com.lovo.EntInfoMan.servlet;

import com.lovo.EntInfoMan.bean.Address;
import com.lovo.EntInfoMan.service.AddressService;
import com.lovo.EntInfoMan.service.impl.AddressServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdataAddressServlet")
public class UpdataAddressServlet extends HttpServlet {

    AddressService as = new AddressServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        String qq = request.getParameter("qq");
        String company = request.getParameter("company");
        String address = request.getParameter("address");
        int postcode = Integer.valueOf(request.getParameter("postcode"));

        Address a = new Address(id, name, sex, mobile, email, qq, company, address, postcode);

        response.getWriter().println("success:" + as.updata(a));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
