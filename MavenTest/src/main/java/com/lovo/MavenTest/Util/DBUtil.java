package com.lovo.MavenTest.Util;

import java.sql.*;

public class DBUtil {//userinfo
    private final String URL = "jdbc:mysql://127.0.0.1:3306/userinfo?useUnicode=true&characterEncoding=UTF-8";
    private final String USER = "root";
    private final String PASSWORD = "123456";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;
    public String sql = "";
    public int n = 0;

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void connection() throws SQLException {
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void close(){
        try {
            if(rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if(ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if(conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
