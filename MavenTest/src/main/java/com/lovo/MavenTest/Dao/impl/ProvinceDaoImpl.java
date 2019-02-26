package com.lovo.MavenTest.Dao.impl;

import com.lovo.MavenTest.Dao.IProvinceDao;
import com.lovo.MavenTest.Util.DBUtil;
import com.lovo.MavenTest.bean.Province;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProvinceDaoImpl extends DBUtil implements IProvinceDao {
    @Override
    public List<Province> getlist() {

        List<Province> list = new ArrayList<>();

        try {
            connection();

            sql = "select * from province";

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                Province province = new Province();
                province.setId(rs.getInt(1));
                province.setCode(rs.getInt(2));
                province.setName(rs.getString(3));

                list.add(province);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return list;
    }
}
