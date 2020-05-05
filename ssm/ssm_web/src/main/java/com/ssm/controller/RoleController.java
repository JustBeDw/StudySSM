package com.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.ssm.dao.IRoleDao;
import com.ssm.entity.Permission;
import com.ssm.entity.Role;
import com.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-04-30 21:35
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService iRoleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,
                                @RequestParam(name = "size",required = true,defaultValue = "4")Integer size
    ) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = iRoleService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(roleList);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }


    @RequestMapping("/save.do")
    public String save(Role role) throws Exception {
        iRoleService.save(role);
        return "redirect:findAll.do";
    }


    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id",required = true)String roleId) throws Exception {
        Role role = iRoleService.findById(roleId);
        List<Permission> otherpermissionList = iRoleService.findOtherPermissions(roleId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("role",role);
        modelAndView.addObject("permissionList",otherpermissionList);
        modelAndView.setViewName("role-permission-add" );
        return modelAndView;
    }


    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "ids",required = true)int[]permissionIds,
                                      @RequestParam(name = "roleId",required = true)int roleId) throws Exception {
        iRoleService.addPermissionToRole(permissionIds,roleId);

        return "redirect:findAll.do";
    }
}
