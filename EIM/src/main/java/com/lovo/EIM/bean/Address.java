package com.lovo.EIM.bean;

public class Address {
    private int id;
    private String name;
    private String sex;
    private String mobile;
    private String email;
    private String qq;
    private String company;
    private String address;
    private int postcode;

    public Address() {
    }

    public Address(int id, String name, String sex, String mobile, String email, String qq, String company, String address, int postcode) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.mobile = mobile;
        this.email = email;
        this.qq = qq;
        this.company = company;
        this.address = address;
        this.postcode = postcode;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", qq='" + qq + '\'' +
                ", company='" + company + '\'' +
                ", address='" + address + '\'' +
                ", postcode=" + postcode +
                '}';
    }
}
