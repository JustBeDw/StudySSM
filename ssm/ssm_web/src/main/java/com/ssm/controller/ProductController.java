package com.ssm.controller;

import com.ssm.entity.Product;
import com.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-04-27 16:24
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;


    /**
     * 查询全部产品
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
            List<Product> productList = productService.findAll();
            modelAndView.addObject("productList",productList);
            modelAndView.setViewName("product-list");
        return modelAndView;
    }

    /**
     * 插入产品
     * @param product
     * @return
     * @throws Exception
     */
    @RequestMapping("/save.do")
    public String  save(Product product) throws Exception {
        productService.save(product);
        return "redirect:findAll.do";
    }

}
