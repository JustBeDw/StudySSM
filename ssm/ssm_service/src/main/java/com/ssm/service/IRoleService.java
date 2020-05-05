package com.ssm.service;

import com.ssm.entity.Permission;
import com.ssm.entity.Role;
import org.apache.ibatis.annotations.Results;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-04-30 21:38
 */
public interface IRoleService {

    /**
     * 查询所有角色
     * @return
     */
    List<Role> findAll(int page,int size) throws Exception;


    /**
     * 创建一个Role
     * @param role 角色
     */
    void save(Role role) throws Exception;

    Role findById(String roleId) throws Exception;

    List<Permission> findOtherPermissions(String roleId) throws Exception;

    void addPermissionToRole(int[] permissionIds,int roleId) throws Exception;
}
