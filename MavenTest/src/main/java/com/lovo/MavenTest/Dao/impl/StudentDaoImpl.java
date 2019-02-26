package com.lovo.MavenTest.Dao.impl;

import com.lovo.MavenTest.Dao.IStudentDao;
import com.lovo.MavenTest.Util.DBUtil;
import com.lovo.MavenTest.bean.Student;
import com.lovo.MavenTest.bean.StudentSelect;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl extends DBUtil implements IStudentDao {

    @Override
    public List<Student> getlist(StudentSelect ss, int pageNo, int pageSize) {

        List<Student> list = new ArrayList<>();

        try {
            connection();

            sql = "select * from stuscore where 1=1";

            if (ss != null) {
                if (ss.getGrade() != null && ss.getGrade() != "") {
                    sql += " and grade like '%" + ss.getGrade() + "%'";
                }
                if (ss.getSex() != null && ss.getSex() != "") {
                    sql += " and sex = '" + ss.getSex() + "'";
                }
                if (ss.getScoreMin() != 0) {
                    sql += " and score >= " + ss.getScoreMin();
                }
                if (ss.getScoreMax() != 0) {
                    sql += " and score <= " + ss.getScoreMax();
                }
            }
            sql += " limit ?,?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (pageNo - 1) * pageSize < 0 ? 0 : (pageNo - 1) * pageSize);
            ps.setInt(2, pageSize);

            rs = ps.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setGrade(rs.getString("grade"));
                student.setSex(rs.getString("sex"));
                student.setAge(rs.getInt("age"));
                student.setScore(rs.getInt("score"));
                list.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return list;
    }

    @Override
    public int getTotalPage(StudentSelect ss) {

        try {
            connection();

            sql = "select count(*) from stuscore where 1=1";

            if (ss != null) {
                if (ss.getGrade() != null && ss.getGrade() != "") {
                    sql += " and grade like '%" + ss.getGrade() + "%'";
                }
                if (ss.getSex() != null && ss.getSex() != "") {
                    sql += " and sex = '" + ss.getSex() + "'";
                }
                if (ss.getScoreMin() != 0) {
                    sql += " and score >= " + ss.getScoreMin();
                }
                if (ss.getScoreMax() != 0) {
                    sql += " and score <= " + ss.getScoreMax();
                }
            }

            ps = conn.prepareStatement(sql);

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
}
