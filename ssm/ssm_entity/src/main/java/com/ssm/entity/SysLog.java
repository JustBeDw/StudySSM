package com.ssm.entity;

import com.ssm.utils.DateUtils;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Administrator
 * @date 2020-05-02 21:40
 * 日志类
 */
public class SysLog {

    /**
     * 日志唯一标识
     */
    private int id;
    /**
     * 访问开始时间
     */
    private Date visitTime;
    /**
     * 访问开始时间以字符串类型显示在页面上
     */
    private String visitTimeStr;
    /**
     * 用户名
     */
    private String username;
    /**
     * ip地址
     */
    private String ip;
    /**
     * 访问地址
     */
    private String url;
    /**
     * 执行时间
     */
    private Long executionTime;
    /**
     * 访问方法
     */
    private String method;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getVisitTimeStr() {
        if (visitTime!=null){
            visitTimeStr = DateUtils.dateToString(visitTime,"yyyy-MM-dd hh:mm:ss");
        }
        return visitTimeStr;
    }

    public void setVisitTimeStr(String visitTimeStr) {
        this.visitTimeStr = visitTimeStr;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Long executionTime) {
        this.executionTime = executionTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
