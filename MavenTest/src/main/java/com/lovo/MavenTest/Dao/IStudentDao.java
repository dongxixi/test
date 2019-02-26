package com.lovo.MavenTest.Dao;

import com.lovo.MavenTest.bean.Student;
import com.lovo.MavenTest.bean.StudentSelect;

import java.util.List;

public interface IStudentDao {
    public List<Student> getlist(StudentSelect ss, int pageNo, int pageSize);

    public int getTotalPage(StudentSelect ss);
}
