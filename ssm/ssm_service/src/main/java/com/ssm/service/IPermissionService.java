package com.ssm.service;

import com.ssm.entity.Permission;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-04-30 22:11
 */
public interface IPermissionService {

    /**
     *
     * @return
     * @throws Exception
     */
    List<Permission> findAll(int page,int size) throws Exception;

    /**
     *
     * @param permission
     * @throws Exception
     */
    void save(Permission permission) throws Exception;
}
