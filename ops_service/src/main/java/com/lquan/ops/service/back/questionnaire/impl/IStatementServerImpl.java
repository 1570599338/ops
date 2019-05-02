package com.lquan.ops.service.back.questionnaire.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lquan.ops.dao.StatementMapper;
import com.lquan.ops.model.back.po.Statement;
import com.lquan.ops.service.back.questionnaire.IStatementServer;
import com.lquan.ops.util.constant.GlobalConstant;

@Service("statementServer")
public class IStatementServerImpl implements IStatementServer{
	
	@Autowired
	private StatementMapper statementMapper;

	/**
	 * 创建欢迎语
	 * @param recond
	 * @return
	 * 
	 */
	@Override
	public void createStatement(List<Statement> list,String userName) {
		for(Statement bean:list) {
			bean.setCreatedAt(new Date());
			bean.setCreatedBy(userName);
			bean.setID(null);
			bean.setActive(GlobalConstant.ACTIVE_YES);
			statementMapper.insertSelective(bean);
		}
	}

	/**
	 * 查询欢迎语
	 * @param templateid
	 */
	@Override
	public List<Statement> searchStatement(Integer templateid) {
		return statementMapper.selectByTemplateId(templateid);
	}

}
