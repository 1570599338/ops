package com.lquan.web.control.questionnaire;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lquan.ops.model.po.Question;
import com.lquan.ops.model.req.questionnaire.QuestionReq;
import com.lquan.ops.model.resp.questionnaire.QuestionResp;
import com.lquan.ops.service.questionnaire.IQuestionServer;
import com.lquan.ops.service.questionnaire.IQuestionServer2;
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
	@RequestMapping(value="/delete")
	public ResponseJson toDelete(@RequestBody Question record,HttpServletRequest request, HttpServletResponse response) throws Exception{
		String user ="admin";
		try {
			 Question  bean= this.questionServer.deleteQuestion(record,user);
			return ResponseResult.getOkResponse(bean);
		} catch (Exception e) {
			log.error("添加问题和选项数据异常:{}",e);
		}
	    return ResponseResult.getErrorResponse(ReturnCode.DB_OPERATION_FAILURE, ReturnCode.getReturnMsg(ReturnCode.DB_OPERATION_FAILURE));
		
//		if(this.questionServer.deleteQuestion(json))
//			message = "message:success";
//		else
//			message = "message:error";
//		//JSONArray json = JSONArray.fromObject(question);
//		PrintWriter out = response.getWriter();	
//		//拼接的json数据多出一对“【】”，所以先去掉
//	//	String resultStr = json.toString().substring(1,json.toString().length()-1);
//		out.write(json.toString());			
//		out.flush();			
//		out.close();
	} 
//	
//	/**
//	 * 问题排序
//	 * @param json
//	 * @param request
//	 * @param response
//	 * @throws Exception
//	 */
//	@RequestMapping(value="/move")
//	@ResponseBody
//	public   void toQuestMove(@RequestBody List<Orders> orderList,HttpServletRequest request, HttpServletResponse response) throws Exception{
//		response.setContentType("text/json; charset=UTF-8"); // 注意设置为json
//		response.setCharacterEncoding("UTF-8");// 传送中文时防止乱码
//		String message ="";
//		System.out.println("*********"+orderList.toString());
//		/*String firstID = request.getParameter("firstID");
//		String firstDispIndex = request.getParameter("firstDispIndex");
//		String secondID = request.getParameter("secondID");
//		String secondDispIndex = request.getParameter("secondDispIndex");*/
//		
//		for(Orders order :orderList){
//			this.questionServer.moveQuestion(order.getId(), order.getDispIndex());
//		}
//	
//		message = "[{message:success}]";
//		JSONArray json = JSONArray.fromObject(orderList);
//		PrintWriter out = response.getWriter();	
//		//拼接的json数据多出一对“【】”，所以先去掉
//		String resultStr = json.toString().substring(1,json.toString().length()-1);
//		out.write(resultStr);			
//		out.flush();			
//		out.close();
//	} 	
//	
//	/**
//	 * 保存题号及其他操作
//	 * @param json
//	 * @param request
//	 * @param response
//	 * @throws Exception
//	 */
//	@RequestMapping(value="/update")
//	@ResponseBody
//	public   void updateQuestionEx(@RequestBody JSONObject jsonObject,HttpServletRequest request, HttpServletResponse response) throws Exception{
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
