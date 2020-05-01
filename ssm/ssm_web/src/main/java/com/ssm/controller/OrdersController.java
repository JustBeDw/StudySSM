package com.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.ssm.entity.Orders;
import com.ssm.service.IOrdersService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-04-28 23:32
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService ordersService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")int page,
                                @RequestParam(name = "size", required = true,defaultValue = "4")int size)
            throws Exception {

        ModelAndView modelAndView = new ModelAndView();
        List<Orders> ordersList = ordersService.findAll(page,size);
//        pageInfo就是分页的一个bean
        PageInfo pageInfo = new PageInfo(ordersList);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("orders-list");
        return modelAndView;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) int ordersId) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Orders orders = ordersService.findById(ordersId);
        modelAndView.addObject("orders",orders);
        modelAndView.setViewName("orders-show");
        return modelAndView;

    }
}
