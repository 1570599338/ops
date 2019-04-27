package com.lquan.ops.service.questionnaire;

import java.util.List;

import com.lquan.ops.model.po.Statement;

public interface IStatementServer {
	
	/**
	 * 创建欢迎语
	 * @param recond
	 * @param userName
	 */
	public void createStatement(List<Statement> recond,String userName);

}
