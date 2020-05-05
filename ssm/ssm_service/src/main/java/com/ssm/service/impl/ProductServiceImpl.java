package com.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.ssm.dao.IProductDao;
import com.ssm.entity.Product;
import com.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-04-27 16:27
 */
@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao iProductDao;

    public List<Product> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page, size);
        return iProductDao.findAll();
    }

    public void save(Product product) throws Exception {
        iProductDao.save(product);
    }
}
