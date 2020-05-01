package com.ssm.service.impl;

import com.ssm.dao.IPermissionDao;
import com.ssm.entity.Permission;
import com.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-04-30 22:12
 */
@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao iPermissionDao;


    public List<Permission> findAll() throws Exception {
        return iPermissionDao.findAll();
    }


    public void save(Permission permission) throws Exception {
        iPermissionDao.save(permission);
    }
}
