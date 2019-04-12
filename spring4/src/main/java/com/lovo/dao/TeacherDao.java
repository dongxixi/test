package com.lovo.dao;

import com.lovo.bean.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherDao extends CrudRepository<Teacher, String> {


}
