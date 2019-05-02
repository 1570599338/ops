package com.lquan.ops.service.back.questionnaire;

import java.util.List;

import com.lquan.ops.model.back.po.Project;

/**
 * 
 * @author lquan
 *
 */
public interface IProjectServer {
	
	
    /***
     * 查询所有的项目
     * @param para
     * @return
     */
   List<Project> selectAllProduct(Project para);

}
