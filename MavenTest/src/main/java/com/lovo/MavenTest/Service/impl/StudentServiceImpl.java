package com.lovo.MavenTest.Service.impl;

import com.lovo.MavenTest.Dao.IStudentDao;
import com.lovo.MavenTest.Dao.impl.StudentDaoImpl;
import com.lovo.MavenTest.Service.IStudentService;
import com.lovo.MavenTest.Util.DBUtil;
import com.lovo.MavenTest.bean.Student;
import com.lovo.MavenTest.bean.StudentSelect;

import java.util.List;

public class StudentServiceImpl extends DBUtil implements IStudentService {

    IStudentDao sd = new StudentDaoImpl();

    @Override
    public List<Student> getlist(StudentSelect ss, int pageNo, int pageSize) {
        return sd.getlist(ss, pageNo ,pageSize);
    }

    @Override
    public int getTotalPage(StudentSelect ss) {
        return sd.getTotalPage(ss);
    }
}
