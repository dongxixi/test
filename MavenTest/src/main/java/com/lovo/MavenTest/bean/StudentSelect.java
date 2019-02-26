package com.lovo.MavenTest.bean;

public class StudentSelect {
    private String grade;
    private String sex;
    private int scoreMin;
    private int scoreMax;

    public StudentSelect() {
    }

    public StudentSelect(String grade, String sex, int scoreMin, int scoreMax) {
        this.grade = grade;
        this.sex = sex;
        this.scoreMin = scoreMin;
        this.scoreMax = scoreMax;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getScoreMin() {
        return scoreMin;
    }

    public void setScoreMin(int scoreMin) {
        this.scoreMin = scoreMin;
    }

    public int getScoreMax() {
        return scoreMax;
    }

    public void setScoreMax(int scoreMax) {
        this.scoreMax = scoreMax;
    }
}
