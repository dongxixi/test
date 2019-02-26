package com.lovo.MavenTest.bean;

public class Area {
    private int id;
    private int code;
    private String name;
    private int cityCode;

    public Area() {
    }

    public Area(int id, int code, String name, int cityCode) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.cityCode = cityCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    @Override
    public String toString() {
        return "{"
                + "\"id\":\"" + id + "\""
                + ", \"code\":\"" + code + "\""
                + ", \"name\":\"" + name + "\""
                + ", \"cityCode\":\"" + cityCode + "\""
                + "}";
    }
}
