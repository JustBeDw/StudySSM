package com.ssm.service;

import com.ssm.entity.SysLog;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-05-02 22:38
 */
public interface ISysService {

    /**
     * 新增日志
     * @param sysLog
     * @throws Exception
     */
    public void save(SysLog sysLog) throws Exception;

    /**
     * 查询日志
     * @ param page
     * @ param size
     * @return
     * @throws Exception
     */
    //int page,int size
    List<SysLog> findAll() throws Exception;
}
