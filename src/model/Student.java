package model;

import java.util.Date;

public class Student {

    // 学号
    private int sno;

    // 姓名
    private String name;

    // 班级id
    private int clazzId;


    // getter and setter
    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClazzId() {
        return clazzId;
    }

    public void setClazzId(int clazzId) {
        this.clazzId = clazzId;
    }
}
