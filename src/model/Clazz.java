package model;

import java.util.Date;

public class Clazz {

    // 班级id
    private int id;

    // 班级名称
    private String clazzName;

    // 班级简称
    private String clazzAlias;

    // 是否为创新班
    private int isSpecial;

    // 学校
    private String school;

    // 专业
    private String major;

    // 班级创建时间
    private Date setupDate;

    // 班长
    private String monitor;

    // 团支书
    private String secretary;

    // 学习委员
    private String commisStudy;

    // 班主任
    private String teacher;

    // qq群
    private String qq;

    // 微信群
    private String wechat;

    // 人数
    private int number;

    // 女生人数
    private int numberGirl;

    // 班级荣耀
    private String honors;

    // 班费余额
    private double currentBalance;


    public int getId() {
        return id;
    }


    // getter and setter

    public void setId(int id) {
        this.id = id;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public String getClazzAlias() {
        return clazzAlias;
    }

    public void setClazzAlias(String clazzAlias) {
        this.clazzAlias = clazzAlias;
    }

    public int getIsSpecial() {
        return isSpecial;
    }

    public void setIsSpecial(int isSpecial) {
        this.isSpecial = isSpecial;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Date getSetupDate() {
        return setupDate;
    }

    public void setSetupDate(Date setupDate) {
        this.setupDate = setupDate;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public String getSecretary() {
        return secretary;
    }

    public void setSecretary(String secretary) {
        this.secretary = secretary;
    }

    public String getCommisStudy() {
        return commisStudy;
    }

    public void setCommisStudy(String commisStudy) {
        this.commisStudy = commisStudy;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumberGirl() {
        return numberGirl;
    }

    public void setNumberGirl(int numberGirl) {
        this.numberGirl = numberGirl;
    }

    public String getHonors() {
        return honors;
    }

    public void setHonors(String honors) {
        this.honors = honors;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }
}
