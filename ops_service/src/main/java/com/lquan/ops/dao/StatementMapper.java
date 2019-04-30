package com.lquan.ops.dao;

import java.util.List;

import com.lquan.ops.model.po.Statement;

public interface StatementMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(Statement record);

    int insertSelective(Statement record);

    Statement selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(Statement record);

    int updateByPrimaryKey(Statement record);
    
    /**
     * 查询欢迎语
     * @param templateid
     * @return
     */
    public List<Statement> selectByTemplateId(Integer templateid);
}