package com.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.ssm.entity.SysLog;
import com.ssm.service.ISysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-05-02 23:22
 */
@Controller
@RequestMapping("/SysLog")
public class SysLogController {

    @Autowired
    private ISysService iSysService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,
                                @RequestParam(name = "size",required = true,defaultValue = "10")Integer size
    ) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<SysLog> sysLogList = iSysService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(sysLogList);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("syslog-list");
        return modelAndView;
    }
}
