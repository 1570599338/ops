package com.lquan.ops.service.questionnaire;

import java.util.List;

import com.lquan.ops.model.po.Orders;
import com.lquan.ops.model.po.QueOption;
import com.lquan.ops.model.po.Question;
import com.lquan.ops.model.req.questionnaire.QuestionReq;
import com.lquan.ops.model.resp.questionnaire.QuestionResp;

//import net.sf.json.JSONObject;

public interface IQuestionServer {
	
	
	/**
	 * 插入题目
	 * @param record
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public  QuestionReq createQuestion(QuestionReq record, String user);
	
	/**
	 * 删除题目
	 * @param question
	 * @return
	 * @throws Exception
	 */
	public Question deleteQuestion(Question question, String user);
	
	/**
	 *  调换题目的顺序
	 * @param id 第一个题目的ID
	 * @param dispIndex 第一个题目的序号
	 * @return
	 * @throws Exception
	 */
	public List<Orders> moveQuestion(List<Orders> objs) throws Exception;
	
	
	/**
	 * 设置题目的问题
	 * @param question
	 * @return
	 * @throws Exception
	 */
	public QuestionReq updateQuestion(QuestionReq question,String user);
	
	
	
	/**
	 * 插入选项数据
	 * @param arg
	 * @return
	 * @throws Exception
	 */
	//public Boolean createOPtion(Object[] arg) throws Exception;
	
	

	/**
	 * 获取问卷所有数据
	 * @param id 问卷的ID
	 * @return
	 * @throws Exception
	 */
	public List<QuestionResp> searchQuestionList(Integer id) throws Exception;
	
	/**
	 * 获取问卷的选项
	 * @param id
	 * @return
	 * @throws Exception
	 */
	//public List<QueOption> getQueOption(Long id) throws Exception;
	
	/**
	 * 题目的题目的相关的设置
	 * @param arg
	 * @return
	 * @throws Exception
	 */
	//public Boolean updateQuestion(Object[] arg) throws Exception;
}
