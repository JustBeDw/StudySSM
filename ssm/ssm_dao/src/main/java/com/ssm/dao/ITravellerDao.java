package com.ssm.dao;

import com.ssm.entity.Traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-04-29 20:18
 */
@Repository
public interface ITravellerDao {

    /**
     * 旅客和订单为多对多关系，所以需要中间表先用订单号查出旅客id，再由旅客id查寻旅客信息
     * @param ordersId 订单号
     * @return
     * @throws Exception
     */
    @Select("SELECT * FROM traveller where id in (SELECT travellerId FROM order_traveller WHERE orderId = #{ordersId})")
    public List<Traveller> findByOrdersId(int ordersId) throws Exception;
}
