package com.ssm.service;

import com.ssm.entity.SysLog;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-05-02 22:38
 */
public interface ISysService {

    public void save(SysLog sysLog) throws Exception;

    List<SysLog> findAll(int page,int size) throws Exception;
}
