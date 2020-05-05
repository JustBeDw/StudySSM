package com.ssm.dao;

import com.ssm.entity.Role;
import com.ssm.entity.UserInfo;
import org.apache.ibatis.annotations.*;


import java.util.List;

/**
 * @author Administrator
 * @date 2020-04-30 10:33
 */
public interface IUserDao {

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from users")
    List<UserInfo> findAll() throws Exception;


    /**
     * 登陆，查询用户名和密码是否匹配
     * column 对应数据库的字段，property 对应实体类的属性
     * Many 将 id 作为参数给 findRoleByUserId 方法，查询权限信息。
     * @param username 用户名
     * @return
     * @throws Exception
     */
    @Select("select * from users where username = #{username}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "email",property = "email"),
            @Result(column = "password",property = "password"),
            @Result(column = "phoneNum",property = "phoneNum"),
            @Result(column = "status",property = "status"),
            @Result(column = "id",property = "roles",javaType = java.util.List.class ,
                    many = @Many(select = "com.ssm.dao.IRoleDao.findRoleByUserId"))
    })
    public UserInfo findByUsername(String username) throws Exception;


    /**
     * 新建用户
     * @param userInfo 用户信息
     * @throws Exception
     */
    @Select("insert into users (email,username,password,phoneNum,status) " +
            "values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo) throws Exception;


    /**
     * 通过用户id查询用户
     * @param id 用户唯一标识
     * @return
     * @throws Exception
     */
    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "email",property = "email"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "phoneNum",property = "phoneNum"),
            @Result(column = "status",property = "status"),
            @Result(column = "id",property = "roles",javaType = java.util.List.class,many = @Many(select = "com.ssm.dao.IRoleDao.findRoleByUserId"))
    })
    UserInfo findById(String id) throws Exception;


    /**
     * 查询其他权限
     * @param userId 用户唯一标识
     * @return
     */
    @Select("select * from role where id not in (select roleId from users_role where  userId = #{userId})")
    List<Role> findOtherRoles(String userId);


    @Insert("insert into users_role(userId,roleId) values (#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);
}
