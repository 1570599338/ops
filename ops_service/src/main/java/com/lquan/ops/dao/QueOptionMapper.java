package com.lquan.ops.dao;

import java.util.List;

import com.lquan.ops.model.back.po.QueOption;

public interface QueOptionMapper {
	int deleteByPrimaryKey(Integer ID);

	int insert(QueOption record);

	int insertSelective(QueOption record);

	QueOption selectByPrimaryKey(Integer ID);

	int updateByPrimaryKeySelective(QueOption record);

	int updateByPrimaryKey(QueOption record);

	/**
	 * 查询题目的选项
	 * @param questionID
	 * @return
	 */
	public List<QueOption> selectQueOptionByQuestionID(Integer questionID);
}