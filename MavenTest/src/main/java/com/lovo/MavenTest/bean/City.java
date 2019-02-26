package com.lovo.MavenTest.bean;

public class City {
    private int id;
    private int code;
    private String name;
    private int provinceCode;

    public City() {
    }

    public City(int id, int code, String name, int provinceCode) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.provinceCode = provinceCode;
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

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }
}
