package com.lovo.EntInfoMan.dao.impl;

import com.lovo.EntInfoMan.bean.User;
import com.lovo.EntInfoMan.dao.IUserDao;

import java.sql.SQLException;

public class UserDaoImpl extends com.lovo.EntInfonMan.Util.DBUtil implements IUserDao {
    @Override
    public int login(User user) {
        try {
            connection();

            sql = "select count(*) from user where username=? and password=?";

            ps = conn.prepareStatement(sql);

            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());

            rs = ps.executeQuery();

            if (rs.next()) {
                n = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return n;
    }

    @Override
    public int register(User user) {
        try {
            connection();

            sql = "insert into user(id,username,password,email) values(null,?,?,?)";

            ps = conn.prepareStatement(sql);

            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());

            n = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return n;
    }
}
