package com.ssm.dao;

import com.ssm.entity.Member;
import org.apache.ibatis.annotations.Select;

/**
 * @author Administrator
 * @date 2020-04-29 20:13
 */
public interface IMemberDao {

    @Select("select * from member")
    public Member findById(int Id) throws Exception;
}
