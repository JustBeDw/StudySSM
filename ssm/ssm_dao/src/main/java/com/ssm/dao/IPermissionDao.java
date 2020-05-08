package com.ssm.dao;

import com.ssm.entity.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-04-30 18:16
 */
@Repository
public interface IPermissionDao {


    /**
     * 查询角色的权限信息，先通过角色 ID 查询出对应的权限 ID ，再查询全新信息
     * @param id 角色唯一标识
     * @return
     * @throws Exception
     */
    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id}) ")
    List<Permission> findPermissionByRoleId(String id) throws Exception;

    /**
     * 查询所有权限
     * @return
     * @throws Exception
     */
    @Select("select * from permission ")
    List<Permission> findAll() throws Exception;

    /**
     * 新增权限
     * @param permission
     * @throws Exception
     */
    @Insert("insert into permission (permissionName,url) values (#{permissionName},#{url})")
    void save(Permission permission) throws Exception;
}
