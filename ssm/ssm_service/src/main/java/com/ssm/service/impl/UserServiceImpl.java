package com.ssm.service.impl;

import com.ssm.dao.IUserDao;
import com.ssm.entity.Role;
import com.ssm.entity.UserInfo;
import com.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @date 2020-04-30 10:36
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {


    @Autowired
    private IUserDao iUserDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    /**
     * 查询所有用户信息
     * @return
     * @throws Exception
     */
    public List<UserInfo> findAll() throws Exception {
        return iUserDao.findAll();
    }

    /**
     * 新增用户
     * @param userInfo - 用户对象，包含所有用户信息
     * @throws Exception
     */
    public void save(UserInfo userInfo) throws Exception {
        //密码加密处理
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        iUserDao.save(userInfo);
    }

    /**
     * 通过指定ID查询用户信息
     * @param id
     * @return
     * @throws Exception
     */
    public UserInfo findById(String id) throws Exception {
        return iUserDao.findById(id);
    }

    /**
     * Spring Security验证用户账号密码是否正确
     * @param username 根据username查询用户
     * @return
     * @throws UsernameNotFoundException
     */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = iUserDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //处理自己用户对象封装成UserDetails对象
        User user = new User(
                userInfo.getUsername(),
                userInfo.getPassword(),
                userInfo.getStatus() == 0 ? false : true,
                true,
                true,
                true,
                getAurthority(userInfo.getRoles()));
        return user;
    }

    /**
     * 获取权限，根据权限查询权限名为USER还是ADMIN
     * @param roles-获取用户权限
     * @return
     */
    public List<SimpleGrantedAuthority>getAurthority(List<Role> roles){
        List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();

        for (Role role : roles){
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }
}
