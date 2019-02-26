package com.lovo.MavenTest.Dao;

import com.lovo.MavenTest.bean.Area;

import java.util.List;

public interface IAreaDao {
    List<Area> getlist(int cityCode);
}
