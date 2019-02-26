package com.lovo.MavenTest.bean;

public class User {
    private String name;
    private int id;
    private Gun gun;

    public User() {
    }

    public User(String name, int id, Gun gun) {
        this.name = name;
        this.id = id;
        this.gun = gun;
    }

    public Gun getGun() {
        return gun;
    }

    public void setGun(Gun gun) {
        this.gun = gun;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
