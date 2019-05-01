package com.lquan.ops.dao;

import java.util.List;

import com.lquan.ops.model.po.Question;

public interface QuestionMapper {
	int deleteByPrimaryKey(Integer id);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);
    
    /**
     * 查询问卷
     * @param templateID
     * @return
     */
    List<Question> searchQuestionListByTemplateID(Integer templateID);
}