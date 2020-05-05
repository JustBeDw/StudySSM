package com.ssm.entity;

import jdk.nashorn.internal.objects.annotations.Setter;

/**
 * @author Administrator
 * @date 2020-04-28 23:22
 * 成员类
 */
public class Member {

    /**
     * 成员唯一标识
     */
    private int id;
    /**
     * 成员名
     */
    private String name;
    /**
     * 成员姓
     */
    private String nickname;
    /**
     * 手机号
     */
    private String phoneNum;
    /**
     * 邮件
     */
    private String email;

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
