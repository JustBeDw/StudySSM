package com.ssm.entity;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-04-30 10:34
 * 用户类
 */
public class UserInfo {

    /**
     * 用户唯一标识
     */
    private int id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户手机号
     */
    private String phoneNum;
    /**
     * 用户状态
     */
    private int status;
    /**
     * 用户状态以字符串类型显示在页面上
     */
    private String statusStr;
    /**
     * 角色信息
     */
    private List<Role> roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusStr() {

        if (status == 0){
            statusStr = "未开启";
        }
        if (status == 1){
            statusStr = "已开启";
        }
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
