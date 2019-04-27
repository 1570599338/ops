package com.lquan.ops.service.questionnaire.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lquan.ops.dao.ProjectMapper;
import com.lquan.ops.model.po.Project;
import com.lquan.ops.service.questionnaire.IProjectServer;




/**
 * 项目名称
 * 
 * @author lquan
 *
 */
@Service("projectServer")
public class ProjectServerImpl implements IProjectServer{
	
	@Autowired
	private ProjectMapper projectMapper;

    /***
     * 查询所有的项目
     * @param para
     * @return
     */
	@Override
	public List<Project> selectAllProduct(Project para) {
		return projectMapper.selectAllProduct(para);
	}



}
