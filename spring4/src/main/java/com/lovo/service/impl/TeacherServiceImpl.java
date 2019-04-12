package com.lovo.service.impl;

import com.lovo.bean.Teacher;
import com.lovo.dao.TeacherDao;
import com.lovo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public int addTeacher(Teacher teacher) {
        Teacher save = teacherDao.save(teacher);
        return save != null ? 1 : 0;
    }
}
