package com.lovo.MavenTest.Dao.impl;

import com.lovo.MavenTest.Dao.ICityDao;
import com.lovo.MavenTest.Util.DBUtil;
import com.lovo.MavenTest.bean.City;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDaoImpl extends DBUtil implements ICityDao {
    @Override
    public List<City> getlist(int prvinceCode) {

        List<City> list = new ArrayList<>();

        try {
            connection();

            sql = "select * from city where provincecode=?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, prvinceCode);

            rs = ps.executeQuery();

            while (rs.next()) {
                City city = new City();
                city.setId(rs.getInt(1));
                city.setCode(rs.getInt(2));
                city.setName(rs.getString(3));
                city.setProvinceCode(rs.getInt(4));

                list.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }

        return list;
    }
}
