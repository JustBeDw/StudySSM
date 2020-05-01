package com.ssm.service;

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
     */
    public List<UserInfo> findAll() throws Exception;

    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(String id) throws Exception;
}
