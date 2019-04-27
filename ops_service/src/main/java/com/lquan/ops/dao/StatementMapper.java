package com.lquan.ops.dao;

import com.lquan.ops.model.po.Statement;

public interface StatementMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(Statement record);

    int insertSelective(Statement record);

    Statement selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(Statement record);

    int updateByPrimaryKey(Statement record);
}