package com.lquan.web.back.control.questionnaire;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lquan.ops.model.back.po.Template;
import com.lquan.ops.model.po.Logic;
import com.lquan.ops.service.back.questionnaire.ILogicServer;
import com.lquan.response.ResponseJson;
import com.lquan.response.ResponseResult;
import com.lquan.response.ReturnCode;

import lombok.extern.slf4j.Slf4j;

/**
 * 逻辑控制
 * @author lquan
 *
 */

@RestController
@Slf4j
@RequestMapping("/logic")
public class LogicController {
	
	@Autowired
	private ILogicServer logicServer;
	
	
	 /**
	  * 查询问卷的逻辑
	  * @param type
	  * @param subjecttype
	  * @param exptype
	  * @param contextid
	  * @param request
	  * @param response
	  * @return
	  */
	 @ResponseBody
	 @RequestMapping("/search")
	 public ResponseJson searchLogic(Byte type,Integer subjecttype,Integer exptype,Integer contextid,HttpServletRequest request, HttpServletResponse response){
		 try {
			 List<Logic> list= logicServer.searchLogic(type, subjecttype, exptype, contextid);
			 log.info("查询问卷逻辑成功");
			return ResponseResult.getOkResponse(list);
		} catch (Exception e) {
			log.error("查询问卷的逻辑数据异常:{}",e);
		}
	    return ResponseResult.getErrorResponse(ReturnCode.DB_OPERATION_FAILURE, ReturnCode.getReturnMsg(ReturnCode.DB_OPERATION_FAILURE));
	 }

	 
	 //submit
	 /**
	  * 保存逻辑
	  * @param record
	  * @param type
	  * @param subjecttype
	  * @param exptype
	  * @param contextid
	  * @param request
	  * @param response
	  * @return
	  */
	 @ResponseBody
	 @RequestMapping("/submit")
	 public ResponseJson submitLogic(Byte type,Integer subjecttype,Integer exptype,Integer contextid,@RequestBody List<Logic> listRecord,HttpServletRequest request, HttpServletResponse response){
		 String userName="userName";
		 try {
			 List<Logic>  list= logicServer.submitLogic(type, subjecttype, exptype, contextid, listRecord,userName);
			 log.info("保存逻辑成功");
			return ResponseResult.getOkResponse(list);
		} catch (Exception e) {
			log.error("保存逻辑数据异常:{}",e);
		}
	    return ResponseResult.getErrorResponse(ReturnCode.DB_OPERATION_FAILURE, ReturnCode.getReturnMsg(ReturnCode.DB_OPERATION_FAILURE));
	 }
}
