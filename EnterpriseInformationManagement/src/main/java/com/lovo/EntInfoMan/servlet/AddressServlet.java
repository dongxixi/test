package com.lovo.EntInfoMan.servlet;

import com.lovo.EntInfoMan.bean.Address;
import com.lovo.EntInfoMan.bean.SendBean;
import com.lovo.EntInfoMan.service.AddressService;
import com.lovo.EntInfoMan.service.impl.AddressServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/AddressServlet")
public class AddressServlet extends HttpServlet {

    AddressService as = new AddressServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int pageno = Integer.valueOf(request.getParameter("pageno"));
        int pagesize = Integer.valueOf(request.getParameter("pagesize"));

        List<Address> list = as.getlist(pageno, pagesize);
        int total = as.getTotalNum();
        int pageTotal = total % pagesize == 0 ? total / pagesize : total / pagesize + 1;

        SendBean sendBean = new SendBean(pageTotal, list);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getOutputStream(), sendBean);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
