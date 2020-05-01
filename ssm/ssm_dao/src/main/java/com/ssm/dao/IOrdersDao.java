package com.ssm.dao;

import com.ssm.entity.Orders;
import com.ssm.entity.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-04-28 23:33
 */
@Repository
public interface IOrdersDao {

    /**
     * 查询订单所有信息
     * @Results column-数据库字段名 property-实体类属性名
     * @return
     * @throws Exception
     */
    @Select("select * from orders")
    @Results({
            @Result(id=true, column = "id", property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",javaType = Product.class,one = @One(select = "com.ssm.dao.IProductDao.findById"))
    })
    List<Orders> findAll() throws Exception;

    /**
     * 通过订单ID查询订单信息
     * @param ordersId
     * @return
     * @throws Exception
     */
    @Select("select * from orders where id = #{ordersId}")
    @Results({
            @Result(id=true, column = "id", property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",javaType = Product.class,one = @One(select = "com.ssm.dao.IProductDao.findById")),
            @Result(column = "memberId",property = "member",javaType = Orders.class,one = @One(select = "com.ssm.dao.IMemberDao.findById")),
            @Result(column = "id",property = "travellers",javaType = java.util.List.class,many = @Many(select = "com.ssm.dao.ITravellerDao.findByOrdersId"))
            //根据column提供的id（订单ID），从中间表查询游客ID，
            //就是说：通过column --> 查询出property
    })
    Orders findById(int ordersId) throws Exception;

}
