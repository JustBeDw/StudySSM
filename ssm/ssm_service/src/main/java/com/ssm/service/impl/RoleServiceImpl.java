package com.ssm.service.impl;

import com.ssm.dao.IRoleDao;
import com.ssm.entity.Role;
import com.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-04-30 21:38
 */
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao iRoleDao;

    public List<Role> findAll() throws Exception {
        return iRoleDao.findAll();
    }

    /**
     *
     * @param role 角色
     */
    public void save(Role role) throws Exception {
        iRoleDao.save(role);
    }
}
