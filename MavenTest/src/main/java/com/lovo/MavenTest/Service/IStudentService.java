package com.lovo.MavenTest.Service;

import com.lovo.MavenTest.bean.Student;
import com.lovo.MavenTest.bean.StudentSelect;

import java.util.List;

public interface IStudentService {
    public List<Student> getlist(StudentSelect ss, int pageNo, int pageSize);

    public int getTotalPage(StudentSelect ss);
}
