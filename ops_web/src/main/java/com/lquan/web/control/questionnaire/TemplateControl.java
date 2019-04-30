package com.lquan.web.control.questionnaire;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lquan.ops.model.po.Template;
import com.lquan.ops.service.questionnaire.ITemplateServer;
import com.lquan.response.ResponseJson;
import com.lquan.response.ResponseResult;
import com.lquan.response.ReturnCode;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author lquan
 *
 */

@RestController
@Slf4j
@RequestMapping("/template")
public class TemplateControl {
	
	 @Autowired
	 private ITemplateServer templateServer;
	
	
	 /**
	  * 添加模版出错
	  * @param param
	  * @param request
	  * @param response
	  * @return
	  * 
	  */
	 @ResponseBody
	 @RequestMapping("/create")
	 public ResponseJson createTemplate(@RequestBody Template param,HttpServletRequest request, HttpServletResponse response){
		 try {
			String userName = "test";
			 System.out.println(param);
			 param.setCreatedBy(userName);
			 Template bean= templateServer.createTemplate(param);

			    return ResponseResult.getOkResponse(bean);
		} catch (Exception e) {
			log.error("添加问卷模版:{}",e);
		}
	        return ResponseResult.getErrorResponse(ReturnCode.DB_OPERATION_FAILURE, ReturnCode.getReturnMsg(ReturnCode.DB_OPERATION_FAILURE));
	 }
	 
	 
	 /**
	  * 根据项目的ID查询
	  * @param param
	  * @param request
	  * @param response
	  * @return
	  */
	 @ResponseBody
	 @RequestMapping("/search")
	 public ResponseJson searchTemplate(Integer projectID,HttpServletRequest request, HttpServletResponse response){
		 try {
			 Template template = new Template();
			 template.setProjectID(projectID);
			 List<Template> list= templateServer.searchTemplate(template);
			return ResponseResult.getOkResponse(list);
		} catch (Exception e) {
			log.error("查询问卷的模版数据异常:{}",e);
		}
	    return ResponseResult.getErrorResponse(ReturnCode.DB_OPERATION_FAILURE, ReturnCode.getReturnMsg(ReturnCode.DB_OPERATION_FAILURE));
	 }
	 
	 /**
	  * 
	  * @param projectID
	  * @param request
	  * @param response
	  * @return
	  */
	 @ResponseBody
	 @RequestMapping("/update")
	 public ResponseJson updateTemplate(@RequestBody Template template,HttpServletRequest request, HttpServletResponse response){
		 try {
			templateServer.updateTemplate(template);
			return ResponseResult.getOkResponse(template);
		} catch (Exception e) {
			log.error("查询问卷的模版数据异常:{}",e);
		}
	    return ResponseResult.getErrorResponse(ReturnCode.DB_OPERATION_FAILURE, ReturnCode.getReturnMsg(ReturnCode.DB_OPERATION_FAILURE));
	 }
	
	 /**
	  * 
	  * @param projectID
	  * @param request
	  * @param response
	  * @return
	  */
	 @ResponseBody
	 @RequestMapping("/delete")
	 public ResponseJson deleteTemplate(Integer templateid,HttpServletRequest request, HttpServletResponse response){
		 try {
			 Template template = new Template();
			 template.setID(templateid);
			 List<Template> list= templateServer.searchTemplate(template);
			return ResponseResult.getOkResponse(list);
		} catch (Exception e) {
			log.error("查询问卷的模版数据异常:{}",e);
		}
	    return ResponseResult.getErrorResponse(ReturnCode.DB_OPERATION_FAILURE, ReturnCode.getReturnMsg(ReturnCode.DB_OPERATION_FAILURE));
	 }
	 
	 /**
	  * 根据主键查询问卷模版
	  * @param id
	  * @param request
	  * @param response
	  * @return
	  */
	 @ResponseBody
	 @RequestMapping("/get")
	 public ResponseJson getTemplate(Integer id,HttpServletRequest request, HttpServletResponse response){
		 try {
			 Template template = new Template();
			 template.setID(id);
			 Template result= templateServer.getTemplate(template);
			return ResponseResult.getOkResponse(result);
		} catch (Exception e) {
			log.error("查询问卷的模版数据异常:{}",e);
		}
	    return ResponseResult.getErrorResponse(ReturnCode.DB_OPERATION_FAILURE, ReturnCode.getReturnMsg(ReturnCode.DB_OPERATION_FAILURE));
	 }

}
