package com.lquan.web.back.control.questionnaire;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lquan.ops.model.back.po.Orders;
import com.lquan.ops.model.back.po.Question;
import com.lquan.ops.model.back.req.questionnaire.QuestionReq;
import com.lquan.ops.model.back.resp.questionnaire.QuestionResp;
import com.lquan.ops.service.back.questionnaire.IQuestionServer;
import com.lquan.response.ResponseJson;
import com.lquan.response.ResponseResult;
import com.lquan.response.ReturnCode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="question")
public class QuestionController {
	
	@Resource(name="questionServer")
	public IQuestionServer questionServer;
	/**
	 * 添加问题和选项
	 * @param qu
	 * @param request
	 * @param response
	 * @return 
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/search")
	public  ResponseJson searchQuestionList(Integer templateid,HttpServletRequest request, HttpServletResponse response) throws Exception{
		 try {
			 List<QuestionResp> qolist = this.questionServer.searchQuestionList(templateid);
			return ResponseResult.getOkResponse(qolist);
		} catch (Exception e) {
			log.error("查询问卷的模版数据异常:{}",e);
		}
	    return ResponseResult.getErrorResponse(ReturnCode.DB_OPERATION_FAILURE, ReturnCode.getReturnMsg(ReturnCode.DB_OPERATION_FAILURE));
		
	}
	
	/**
	 * 添加问题和选项
	 * @param qu
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/create")
	public  ResponseJson toLogin(@RequestBody QuestionReq record,HttpServletRequest request, HttpServletResponse response) throws Exception{
		String user ="admin";
		try {
			 QuestionReq  bean= this.questionServer.createQuestion(record,user);
			return ResponseResult.getOkResponse(bean);
		} catch (Exception e) {
			log.error("添加问题和选项数据异常:{}",e);
		}
	    return ResponseResult.getErrorResponse(ReturnCode.DB_OPERATION_FAILURE, ReturnCode.getReturnMsg(ReturnCode.DB_OPERATION_FAILURE));
	}
	
	/**
	 * 删除选项
	 * @param json
	 * @param request
	 * @param response
	 * @return 
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/delete")
	public ResponseJson toDelete(@RequestBody Question record,HttpServletRequest request, HttpServletResponse response) throws Exception{
		String user ="admin";
		try {
			 Question  bean= this.questionServer.deleteQuestion(record,user);
			 log.info("删除题目数成功");
			return ResponseResult.getOkResponse(bean);
		} catch (Exception e) {
			log.error("删除题目数异常:{}",e);
		}
	    return ResponseResult.getErrorResponse(ReturnCode.DB_OPERATION_FAILURE, ReturnCode.getReturnMsg(ReturnCode.DB_OPERATION_FAILURE));

	} 
	
	/**
	 * 问题排序
	 * @param json
	 * @param request
	 * @param response
	 * @return 
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/move")
	public   ResponseJson toQuestMove(@RequestBody List<Orders> orderList,HttpServletRequest request, HttpServletResponse response) throws Exception{
		//String user ="admin";
		try {
			 this.questionServer.moveQuestion(orderList);
			 log.info("删除题目数成功");
			return ResponseResult.getOkResponse(orderList);
		} catch (Exception e) {
			log.error("删除题目数异常:{}",e);
		}
	    return ResponseResult.getErrorResponse(ReturnCode.DB_OPERATION_FAILURE, ReturnCode.getReturnMsg(ReturnCode.DB_OPERATION_FAILURE));
	} 
	
	
	/**
	 * 保存题号及其他操作
	 * @param json
	 * @param request
	 * @param response
	 * @return 
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/update")
	public   ResponseJson updateQuestionEx(@RequestBody QuestionReq record,HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("text/json; charset=UTF-8"); // 注意设置为json
		response.setCharacterEncoding("UTF-8");// 传送中文时防止乱码
		String user ="admin";
		try {
			 QuestionReq bean = this.questionServer.updateQuestion(record,user);
			 log.info("修改题目数成功");
			return ResponseResult.getOkResponse(bean);
		} catch (Exception e) {
			log.error("修改题目数异常:{}",e);
		}
	    return ResponseResult.getErrorResponse(ReturnCode.DB_OPERATION_FAILURE, ReturnCode.getReturnMsg(ReturnCode.DB_OPERATION_FAILURE));
	} 
//
//	/**
//	 * 设置题目
//	 * @param jsonObject
//	 * @param request
//	 * @param response
//	 * @throws Exception
//	 */
//	@RequestMapping(value="/updatetitle")
//	@ResponseBody
//	public   void updateTitle(@RequestBody JSONObject jsonObject,HttpServletRequest request, HttpServletResponse response) throws Exception{
//		response.setContentType("text/json; charset=UTF-8"); // 注意设置为json
//		response.setCharacterEncoding("UTF-8");// 传送中文时防止乱码
//		String message ="";
//		System.out.println("****xxxx*****"+jsonObject.toString());
//		Question question = (Question) jsonObject.toBean(jsonObject, Question.class);
//			this.questionServer.updateQuestion(question.getupdateArgs());
//	
//		message = "[{message:success}]";
//		JSONArray json = JSONArray.fromObject(question);
//		PrintWriter out = response.getWriter();	
//		//拼接的json数据多出一对“【】”，所以先去掉
//		//String resultStr = json.toString().substring(1,json.toString().length()-1);
//		out.write(json.toString());			
//		out.flush();			
//		out.close();
//	} 
}
