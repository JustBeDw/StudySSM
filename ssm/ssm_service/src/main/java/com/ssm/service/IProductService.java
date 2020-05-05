package com.ssm.service;

import com.ssm.entity.Product;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-04-27 16:20
 */

public interface IProductService {

    /**
     * 查询所有产品的信息
     * @return
     * @throws Exception
     */
    public List<Product> findAll(int page,int size) throws Exception;

    /**
     * 增加产品
     * @param product
     * @throws Exception
     */
    public void save(Product product) throws Exception;
}
