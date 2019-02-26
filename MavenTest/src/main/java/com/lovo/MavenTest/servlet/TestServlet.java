package com.lovo.MavenTest.servlet;

import javax.servlet.annotation.WebServlet;
import java.io.*;
import java.util.Properties;

@WebServlet("/TestServlet")
public class TestServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String host = request.getParameter("host");
        String port = request.getParameter("port");
        Properties properties = new Properties();
        properties.setProperty("host", host);
        properties.setProperty("port", port);
        properties.store(new FileOutputStream(getServletContext().getRealPath("/config.properties")),null);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        Properties properties = new Properties();
        properties.load(new BufferedReader(new FileReader(getServletContext().getRealPath("/config.properties"))));
        String host = properties.getProperty("host");
        String port = properties.getProperty("port");
        out.println(host + ":" + port);
    }
}
