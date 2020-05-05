package com.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.ssm.dao.IRoleDao;
import com.ssm.entity.Permission;
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

    public List<Role> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        return iRoleDao.findAll();
    }

    /**
     *
     * @param role 角色
     */
    public void save(Role role) throws Exception {
        iRoleDao.save(role);
    }

    public Role findById(String roleId) throws Exception {
        return iRoleDao.findById(roleId);
    }

    public List<Permission> findOtherPermissions(String roleId) throws Exception {
        return iRoleDao.findOtherPermissions(roleId);
    }



    public void addPermissionToRole(int[] permissionIds ,int roleId) throws Exception {
        for (int permissionId : permissionIds){
            iRoleDao.addPermissionToRole(permissionId,roleId);
        }
    }

}
