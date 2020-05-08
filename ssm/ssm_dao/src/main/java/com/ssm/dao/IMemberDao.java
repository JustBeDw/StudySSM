package com.ssm.dao;

import com.ssm.entity.Member;
import org.apache.ibatis.annotations.Select;

/**
 * @author Administrator
 * @date 2020-04-29 20:13
 */
public interface IMemberDao {

    /**
     * 查询所有成员
     * @param Id 成员
     * @return
     * @throws Exception
     */
    @Select("select * from member where id = #{Id}")
    public Member findById(int Id) throws Exception;
}
