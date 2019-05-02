package com.lquan.web.mobile.control.questionnaire;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lquan.ops.model.back.po.Template;
import com.lquan.response.ResponseJson;
import com.lquan.response.ResponseResult;
import com.lquan.response.ReturnCode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/template")
public class SurveyControl {
	
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

}
