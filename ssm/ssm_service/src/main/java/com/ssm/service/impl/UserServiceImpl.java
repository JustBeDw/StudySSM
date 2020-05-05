package com.ssm.service.impl;

import com.github.pagehelper.PageHelper;
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
    public List<UserInfo> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page, size);
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
     *
     * @param userId
     * @return
     * @throws Exception
     */
    public List<Role> findOtherRoles(String userId) throws Exception {
        return iUserDao.findOtherRoles(userId);
    }

    public void addRoleToUser(String userId, String[] roleIds) {
        for (String roleId:roleIds){
            iUserDao.addRoleToUser(userId,roleId);
        }
    }

    /**
     * UserService 继承了 UserDetailsService 所以重写 loadUserByUsername 方法，默认提供 username 参数
     * Spring Security验证用户账号密码是否正确
     * @param username 根据username查询用户
     * @return
     * @throws UsernameNotFoundException
     */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //返回一个user
        UserInfo userInfo = null;
        try {
            //通过 username 查询用户
            userInfo = iUserDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //处理自己用户对象封装成UserDetails对象
        User user = new User(
                //用户名
                userInfo.getUsername(),
                //用户密码
                userInfo.getPassword(),
                //判断用户状态是否为0
                userInfo.getStatus() == 0 ? false : true,
                //无期限
                true,
                //不设长
                true,
                //不加锁
                true,
                //获取角色
                getAurthority(userInfo.getRoles()));
        return user;
    }

    /**
     * 获取权限，根据权限查询权限名为USER还是ADMIN
     * @param roles 获取用户权限
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
