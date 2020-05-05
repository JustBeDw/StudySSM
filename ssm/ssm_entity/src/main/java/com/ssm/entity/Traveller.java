package com.ssm.entity;

import jdk.nashorn.internal.objects.annotations.Setter;

/**
 * @author Administrator
 * @date 2020-04-28 23:22
 */
/**
 * 旅客类
 */
public class Traveller {
    /**
     * 旅客唯一标识
     */
    private int id;
    /**
     * 旅客姓名
     */
    private String name;
    /**
     * 旅客性别
     */
    private String sex;
    /**
     * 旅客手机号
     */
    private String phoneNum;
    /**
     * 旅客证
     */
    private Integer credentialsType;
    /**
     * 旅客证以字符串类型显示在页面上
     */
    private String credentialsTypeStr;
    /**
     * 旅客证号
     */
    private String credentialsNum;
    /**
     * 旅客类型
     */
    private Integer travellerType;
    /**
     * 旅客类型以字符串类型显示在页面上
     */
    private String travellerTypeStr;

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

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getCredentialsType() {
        return credentialsType;
    }

    public void setCredentialsType(Integer credentialsType) {
        this.credentialsType = credentialsType;
    }

    public String getCredentialsTypeStr() {
        if (credentialsType!=null){
            if (credentialsType==0){
                credentialsTypeStr = "身份证";
            }
            if (credentialsType==1){
                credentialsTypeStr = "护照";
            }
            if (credentialsType==2){
                credentialsTypeStr = "军官证";
            }
        }
        return credentialsTypeStr;
    }

    public void setCredentialsTypeStr(String credentialsTypeStr) {
        this.credentialsTypeStr = credentialsTypeStr;
    }

    public String getCredentialsNum() {
        return credentialsNum;
    }

    public void setCredentialsNum(String credentialsNum) {
        this.credentialsNum = credentialsNum;
    }

    public Integer getTravellerType() {

        return travellerType;
    }

    public void setTravellerType(Integer travellerType) {
        this.travellerType = travellerType;
    }

    public String getTravellerTypeStr() {
        if (travellerType!=null){
            if (travellerType == 1){
                travellerTypeStr = "儿童";
            }
            if (travellerType == 0){
                travellerTypeStr = "成人";
            }
        }

            return travellerTypeStr;
    }

    public void setTravellerTypeStr(String travellerTypeStr) {
        this.travellerTypeStr = travellerTypeStr;
    }
}
