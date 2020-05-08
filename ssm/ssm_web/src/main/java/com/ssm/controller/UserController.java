package com.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.ssm.entity.Role;
import com.ssm.entity.UserInfo;
import com.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-04-30 10:41
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    /**
     * 展示查询所有用户功能的视图
     * @return
     * @throws Exception
     */
    @RequestMapping("findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,
                                @RequestParam(name = "size",required = true,defaultValue = "4")Integer size
    ) throws Exception {

        ModelAndView modelAndView = new ModelAndView();
        List<UserInfo> userInfoList = iUserService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(userInfoList);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("user-list");

        return modelAndView;
    }

    /**
     * 展示新增用户功能之后重新查询的视图
     * @param userInfo
     * @return
     * @throws Exception
     */
    @RequestMapping("/save.do")
    public String save(UserInfo userInfo) throws Exception {
        iUserService.save(userInfo);
        return "redirect:findAll.do";
    }


    /**
     * 展示通过ID查询用户的视图
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = iUserService.findById(id);
        modelAndView.addObject("user",userInfo);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }

//    @RequestMapping("/update.do")
//    public String update(String id){
//        iUserService.update(id);
//        return "redirect:findAll.do";
//    }

    /**
     * 展示查询可以添加的权限的视图
     * @param userId
     * @return
     * @throws Exception
     */
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true)String userId) throws Exception {
        UserInfo userInfo = iUserService.findById(userId);
        List<Role> roleList = iUserService.findOtherRoles(userId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",userInfo);
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("user-role-add");
        return modelAndView;
    }


    /**
     * 展示查询添加权限给用户后的试图
     * @param userId 用户Id
     * @param roleIds 可添加的角色Id
     */
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true)String userId,
                              @RequestParam(name = "ids",required = true)String [] roleIds){
        iUserService.addRoleToUser(userId,roleIds);
        return "redirect:findAll.do";
    }


}
