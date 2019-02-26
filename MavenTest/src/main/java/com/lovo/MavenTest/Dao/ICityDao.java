package com.lovo.MavenTest.Dao;

import com.lovo.MavenTest.bean.City;

import java.util.List;

public interface ICityDao {
    List<City> getlist(int prvinceCode);
}
