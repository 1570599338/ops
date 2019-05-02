package com.lquan.ops.service.back.questionnaire;

import java.util.List;

import com.lquan.ops.model.back.po.Statement;

public interface IStatementServer {
	
	/**
	 * 创建欢迎语
	 * @param recond
	 * @param userName
	 */
	public void createStatement(List<Statement> recond,String userName);
	
	/**
	 * 查询欢迎语
	 * @param templateid
	 */
	public List<Statement> searchStatement(Integer templateid);

}
