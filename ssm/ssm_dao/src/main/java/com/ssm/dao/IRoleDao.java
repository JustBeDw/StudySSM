package com.ssm.dao;

import com.ssm.entity.Permission;
import com.ssm.entity.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-04-30 13:06
 */
public interface IRoleDao {


    /**
     *  通过 userId 查询自己的角色id，再查询 Role 角色
     *  将 Role 的 Id 作为参数，传递给 findPermissionByRoleId 方法，查询 permission 信息
     * @param userId 用户唯一标识
     * @return
     * @throws Exception
     */
    @Select("SELECT * FROM role WHERE id in (SELECT roleId from users_role where userId = #{userId})")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "roleName",property = "roleName"),
            @Result(column = "roleDesc",property = "roleDesc"),
            @Result(column = "id",property = "permissions",javaType = java.util.List.class,many = @Many(select = "com.ssm.dao.IPermissionDao.findPermissionByRoleId"))
    })
    public List<Role> findRoleByUserId(String userId) throws Exception;

    /**
     * 查询所有角色
     * @return
     * @throws Exception
     */
    @Select("select * from role")
    List<Role> findAll() throws Exception;

    /**
     * 新建一个Role
     * @param role 角色
     * @throws Exception
     */
    @Insert("insert into role (roleName,roleDesc) values (#{roleName},#{roleDesc})")
    void save(Role role) throws Exception;

    /**
     * 通过 ID 查询角色信息
     * @param roleId 角色唯一标识
     * @return
     */
    @Select("select * from role where id = #{roleId}")
    Role findById(String roleId);

    /**
     * 先在中间表 role_permission 查询 permissionId ，再查询 permission 所有信息
     * @param roleId 角色唯一标识
     * @return
     */
    @Select("select * from permission where id not in (select permissionId from role_permission where roleId = #{roleId})")
    List<Permission> findOtherPermissions(String roleId);

    /**
     * 给角色新增权限
     * @param permissionId 权限唯一标识
     * @param roleId 角色唯一标识
     * @throws Exception
     */
    @Insert("insert into role_permission (permissionId,roleId) values (#{permissionId},#{roleId})")
    void addPermissionToRole(@Param("permissionId") int permissionId, @Param("roleId") int roleId) throws Exception;
}
