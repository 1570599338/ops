package com.lquan.web.control.questionnaire;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lquan.ops.model.po.Statement;
import com.lquan.ops.model.po.Template;
import com.lquan.ops.service.questionnaire.IStatementServer;
import com.lquan.ops.service.questionnaire.ITemplateServer;
import com.lquan.response.ResponseJson;
import com.lquan.response.ResponseResult;
import com.lquan.response.ReturnCode;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
@RequestMapping("/statement")
public class StatementControl {
	
	 @Autowired
	 private IStatementServer statementServer;
	
	
	 @ResponseBody
	 @RequestMapping("/create")
	 public ResponseJson createStatement(@RequestBody List<Statement> list,HttpServletRequest request, HttpServletResponse response){
		 try {
			 String userName="test";
			 log.info("请求参数:{}",list);
			 statementServer.createStatement(list, userName);
			return ResponseResult.getOkResponse(list);
		} catch (Exception e) {
			log.error("查询问卷的模版数据异常:{}",e);
		}
	    return ResponseResult.getErrorResponse(ReturnCode.DB_OPERATION_FAILURE, ReturnCode.getReturnMsg(ReturnCode.DB_OPERATION_FAILURE));
	 }
	 
	 /**
	  * 查询欢迎和结束语
	  * @param list
	  * @param request
	  * @param response
	  * @return
	  */
	 @ResponseBody
	 @RequestMapping("/search")
	 public ResponseJson searchStatement(Integer templateid,HttpServletRequest request, HttpServletResponse response){
		 try {
			 List<Statement> list = statementServer.searchStatement(templateid);
			return ResponseResult.getOkResponse(list);
		} catch (Exception e) {
			log.error("查询欢迎和结束语数据异常:{}",e);
		}
	    return ResponseResult.getErrorResponse(ReturnCode.DB_OPERATION_FAILURE, ReturnCode.getReturnMsg(ReturnCode.DB_OPERATION_FAILURE));
	 }

}
