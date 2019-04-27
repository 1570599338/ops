package com.lquan.ops.dao;

import com.lquan.ops.model.po.Template;

public interface TemplateMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(Template record);

    int insertSelective(Template record);

    Template selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(Template record);

    int updateByPrimaryKey(Template record);
}