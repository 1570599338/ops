package com.lquan.ops.dao;

import java.util.List;

import com.lquan.ops.model.back.po.Project;

public interface ProjectMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);
    
    /***
     * 查询所有的项目
     * @param para
     * @return
     */
   List<Project> selectAllProduct(Project para);
}