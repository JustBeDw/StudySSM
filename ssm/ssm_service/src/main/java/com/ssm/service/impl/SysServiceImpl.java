package com.ssm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ssm.dao.ISysDao;
import com.ssm.entity.SysLog;
import com.ssm.service.ISysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-05-02 22:38
 */
@Service
@Transactional
public class SysServiceImpl implements ISysService {

    @Autowired
    private ISysDao iSysDao;


    public void save(SysLog sysLog) throws Exception {
        iSysDao.save(sysLog);
    }

    public List<SysLog> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page, size);
        return iSysDao.findAll();
    }
}
