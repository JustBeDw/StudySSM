package com.ssm.dao;

import com.ssm.entity.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-05-02 22:39
 */
public interface ISysDao {

    /**
     * 新增日志所有信息
     * @param sysLog 日志信息
     * @throws Exception
     */
    @Insert("insert into syslog (visitTime,username,ip,url,executionTime,method) " +
            "values" +
            "(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    public void save(SysLog sysLog) throws Exception;


    /**
     * 查询日志信息
     * @return
     * @throws Exception
     */
    @Select("select * from syslog")
    List<SysLog> findAll() throws Exception;
}
