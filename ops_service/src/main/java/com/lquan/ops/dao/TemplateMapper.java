package com.lquan.ops.dao;

import java.util.List;

import com.lquan.ops.model.back.po.Template;

public interface TemplateMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(Template record);

    int insertSelective(Template record);

    Template selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(Template record);

    int updateByPrimaryKey(Template record);
    
    /**
     *  按条件查询
     * @param record
     * @return
     */
   List<Template> selectByConfidtion(Template record);
}