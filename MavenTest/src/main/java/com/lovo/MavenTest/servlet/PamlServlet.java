package com.lovo.MavenTest.servlet;

import com.lovo.MavenTest.Dao.IAreaDao;
import com.lovo.MavenTest.Dao.ICityDao;
import com.lovo.MavenTest.Dao.IProvinceDao;
import com.lovo.MavenTest.Dao.impl.AreaDaoImpl;
import com.lovo.MavenTest.Dao.impl.CityDaoImpl;
import com.lovo.MavenTest.Dao.impl.ProvinceDaoImpl;
import com.lovo.MavenTest.bean.Area;
import com.lovo.MavenTest.bean.City;
import com.lovo.MavenTest.bean.Province;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/PamlServlet")
public class PamlServlet extends HttpServlet {

    IProvinceDao pd = new ProvinceDaoImpl();
    ICityDao cd = new CityDaoImpl();
    IAreaDao ad = new AreaDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String command = request.getParameter("command");


        StringBuffer str = new StringBuffer();

        if ("province".equals(command)) {
            List<Province> list = pd.getlist();
            str.setLength(0);
            str.append("{list:[");
            for (Province province : list) {
                str.append("{id:");
                str.append(province.getId());
                str.append(",code:");
                str.append(province.getCode());
                str.append(",name:\"");
                str.append(province.getName());
                str.append("\"},");
            }
        } else if ("city".equals(command)) {
            int provincecode = Integer.parseInt(request.getParameter("provincecode"));

            List<City> list = cd.getlist(provincecode);
            str.setLength(0);
            str.append("{list:[");
            for (City city : list) {
                str.append("{id:");
                str.append(city.getId());
                str.append(",code:");
                str.append(city.getCode());
                str.append(",name:\"");
                str.append(city.getName());
                str.append("\",provincecode:");
                str.append(city.getProvinceCode());
                str.append("},");
            }
        } else if ("area".equals(command)) {
            int citycode = Integer.parseInt(request.getParameter("citycode"));
            List<Area> list = ad.getlist(citycode);

            str.setLength(0);
            str.append("{list:[");
            for (Area area : list) {
                str.append("{id:");
                str.append(area.getId());
                str.append(",code:");
                str.append(area.getCode());
                str.append(",name:\"");
                str.append(area.getName());
                str.append("\",citycode:");
                str.append(area.getCityCode());
                str.append("},");
            }
        }
        str.substring(0, str.length() - 1);
        str.append("]}");

        out.println(str.toString());
    }
}
