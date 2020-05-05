package com.ssm.service;

import com.ssm.entity.Role;
import com.ssm.entity.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-04-30 10:34
 */
public interface IUserService extends UserDetailsService {

    /**
     * 查询所有用户
     * @return
     * @Exception s
     */
    public List<UserInfo> findAll(int page,int size) throws Exception;

    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(String id) throws Exception;

    List<Role> findOtherRoles(String userId) throws Exception;

    void addRoleToUser(String userId, String[] roleIds);
}
