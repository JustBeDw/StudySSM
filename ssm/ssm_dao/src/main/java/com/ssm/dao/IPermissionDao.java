package com.ssm.dao;

import com.ssm.entity.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-04-30 18:16
 */
public interface IPermissionDao {


    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from permission where id = (select permissionId from role_permission where roleId=#{id}) ")
    List<Permission> findPermissionByRoleId(String id) throws Exception;


    @Select("select * from permission ")
    List<Permission> findAll() throws Exception;

    @Insert("insert into permission (permissionName,url) values (#{permissionName},#{url})")
    void save(Permission permission) throws Exception;
}
