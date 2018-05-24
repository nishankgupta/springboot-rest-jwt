package com.nishank.springrestjwt.bean;

/**
 * Created by Nishank Gupta on 24-May-18.
 */
public class User {

    private String userName;
    private int age;
    private char sex;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }
}
