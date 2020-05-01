package com.ssm.service;

import com.ssm.entity.Permission;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-04-30 22:11
 */
public interface IPermissionService {


    List<Permission> findAll() throws Exception;

    void save(Permission permission) throws Exception;
}
