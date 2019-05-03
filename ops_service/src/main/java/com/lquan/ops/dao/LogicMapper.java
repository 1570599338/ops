package com.lquan.ops.dao;

import java.util.List;

import com.lquan.ops.model.po.Logic;

public interface LogicMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(Logic record);

    int insertSelective(Logic record);

    Logic selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(Logic record);

    int updateByPrimaryKey(Logic record);
    
    /**
     * 逻辑查询
     * @param record
     * @return
     */
    List<Logic> selectByConfid(Logic record);
    
    /**
     * 删除重复数据
     * @param record
     */
   void deleteBeforeSubmit(Logic record);
}