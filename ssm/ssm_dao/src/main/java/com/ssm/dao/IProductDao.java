package com.ssm.dao;

import com.ssm.entity.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-04-27 16:15
 */
@Repository
public interface IProductDao {
    /**
     * 查询所有产品的信息
     * @return
     * @throws Exception
     */
    @Select("select * from product")
    public List<Product> findAll() throws Exception;

    /**
     * 通过ID查询产品
     * @param id - orders 传过来的productId参数
     * @return
     * @throws Exception
     */
    @Select("select * from product where id=#{id}")
    Product findById(int id) throws Exception;

    /**
     *  添加产品
     * @param product
     */

    @Insert("insert into product (productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus)" +
            "values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    public void save(Product product);


    @Delete("delete from product where id = #{id}")
    void delete(int id);
}
