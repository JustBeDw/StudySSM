package com.ssm.entity;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-04-30 11:01
 * 权限类
 */
public class Permission {

    /**
     * 权限唯一标识
     */
    private int id;
    /**
     * 权限名
     */
    private String permissionName;
    /**
     * 权限地址
     */
    private String url;
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

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
