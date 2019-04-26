package com.lquan.ops.dao;

import com.lquan.ops.model.po.Queoption;

public interface QueoptionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Queoption record);

    int insertSelective(Queoption record);

    Queoption selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Queoption record);

    int updateByPrimaryKey(Queoption record);
}