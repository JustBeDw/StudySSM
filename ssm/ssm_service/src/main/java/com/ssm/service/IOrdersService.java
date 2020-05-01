package com.ssm.service;

import com.ssm.entity.Orders;


import java.util.List;

/**
 * @author Administrator
 * @date 2020-04-28 23:33
 */

public interface IOrdersService {

    /**
     * 查询所有订单信息 且 分页
     * @param page 页码
     * @param size 一页多少条数据
     * @return
     * @throws Exception
     */
    List<Orders> findAll(int page,int size) throws Exception;

    /**
     * 通过订单号查询数据
     * @param ordersId 订单号
     * @return
     * @throws Exception
     */
    Orders findById(int ordersId) throws Exception;
}
