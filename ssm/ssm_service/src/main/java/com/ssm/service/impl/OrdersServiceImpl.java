package com.ssm.service.impl;

import com.github.pagehelper.PageHelper;

import com.ssm.dao.IOrdersDao;
import com.ssm.entity.Orders;
import com.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-04-28 23:33
 */
@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {


    @Autowired
    private IOrdersDao iOrdersDao;

    public List<Orders> findAll(int page,int size) throws Exception {
        //pageNum-页码    pageSize-显示数量
        PageHelper.startPage(page,size);
        return iOrdersDao.findAll();
    }

    public Orders findById(int ordersId) throws Exception {
        return iOrdersDao.findById(ordersId);
    }
}
