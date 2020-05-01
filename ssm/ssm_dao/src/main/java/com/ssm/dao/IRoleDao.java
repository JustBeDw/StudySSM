package com.ssm.dao;

import com.ssm.entity.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-04-30 13:06
 */
public interface IRoleDao {


    /**
     *  通过userId查询自己的权限id，再查询Role权限
     * @param userId
     * @return
     * @throws Exception
     */
    @Select("SELECT * FROM role WHERE id = (SELECT roleId from users_role where userId = #{userId})")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "roleName",property = "roleName"),
            @Result(column = "roleDesc",property = "roleDesc"),
            @Result(column = "id",property = "permissions",javaType = java.util.List.class,many = @Many(select = "com.ssm.dao.IPermissionDao.findPermissionByRoleId"))
    })
    public List<Role> findRoleByUserId(String userId) throws Exception;


    @Select("select * from role")
//    @Results({
//            @Result(id = true,column = "id",property = "id"),
//            @Result(column = "roleName",property = "roleName"),
//            @Result(column = "roleDesc",property = "roleDesc"),
//            @Result(column = "id",property = "permissions",javaType = java.util.List.class,many = @Many(select = ""))
//    })
    List<Role> findAll() throws Exception;


    /**
     * 新建一个Role
     * @param role 角色
     */
    @Insert("insert into role (roleName,roleDesc) values (#{roleName},#{roleDesc})")
    void save(Role role) throws Exception;
}
