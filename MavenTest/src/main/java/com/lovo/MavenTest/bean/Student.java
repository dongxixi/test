package com.lovo.MavenTest.bean;

public class Student {
    private int id;
    private String name;
    private String grade;
    private int score;
    private String sex;
    private int age;

    public Student() {
    }

    public Student(int id, String name, String grade, int score, String sex, int age) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.score = score;
        this.sex = sex;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
