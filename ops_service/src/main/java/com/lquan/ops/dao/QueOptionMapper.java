package com.lquan.ops.dao;

import com.lquan.ops.model.po.QueOption;

public interface QueOptionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QueOption record);

    int insertSelective(QueOption record);

    QueOption selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QueOption record);

    int updateByPrimaryKey(QueOption record);
}