package com.lquan.ops.dao;

import com.lquan.ops.model.po.Logic;

public interface LogicMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(Logic record);

    int insertSelective(Logic record);

    Logic selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(Logic record);

    int updateByPrimaryKey(Logic record);
}