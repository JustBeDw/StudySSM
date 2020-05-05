package com.ssm.controller;


import com.github.pagehelper.PageInfo;
import com.ssm.entity.Permission;
import com.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-04-30 22:09
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService iPermissionService;


    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,
                                @RequestParam(name = "size", required = true,defaultValue = "4")Integer size
    ) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Permission> permissionList = iPermissionService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(permissionList);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("permission-list");
        return modelAndView;
    }

    @RequestMapping("/save.do")
    public String save(Permission permission) throws Exception {
        iPermissionService.save(permission);
        return "redirect:findAll.do";
    }
}
