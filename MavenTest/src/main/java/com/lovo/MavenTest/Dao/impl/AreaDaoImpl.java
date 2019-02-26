package com.lovo.MavenTest.Dao.impl;

import com.lovo.MavenTest.Dao.IAreaDao;
import com.lovo.MavenTest.Util.DBUtil;
import com.lovo.MavenTest.bean.Area;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AreaDaoImpl extends DBUtil implements IAreaDao {
    @Override
    public List<Area> getlist(int cityCode) {

        List<Area> list = new ArrayList<>();

        try {
            connection();

            sql = "select * from area where citycode=?";

            ps = conn.prepareStatement(sql);

            ps.setInt(1,cityCode);

            rs = ps.executeQuery();

            while (rs.next()) {
                Area area = new Area();
                area.setId(rs.getInt(1));
                area.setCode(rs.getInt(2));
                area.setName(rs.getString(3));
                area.setCityCode(rs.getInt(4));

                list.add(area);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return list;
    }
}
