package com.lquan.web.control.questionnaire;

import java.util.Date;
import java.util.Map;

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
import com.lquan.web.HelloController;

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
	
	
	 @ResponseBody
	 @RequestMapping("/create")
	 public ResponseJson createTemplate(@RequestBody Template param,HttpServletRequest request, HttpServletResponse response){
		 String userName = "test";
		 System.out.println(param);
		 param.setCreatedBy(userName);
		 Template bean= templateServer.createTemplate(param);
//	        if(param==null) {
//	            return ResponseResult.getErrorResponse(ReturnCode.REQUEST_PARAM_ERROR, ReturnCode.getReturnMsg(ReturnCode.REQUEST_PARAM_ERROR));
//	        }
//	        if(param.getProductChannel()==null || param.getMemberid() == null) {
//	            log.info("param.getProductChannel():"+param.getProductChannel()+",param.getMemberid()="+param.getMemberid());
//	            return ResponseResult.getErrorResponse(ReturnCode.REQUEST_PARAM_NOTNONE, ReturnCode.getReturnMsg(ReturnCode.REQUEST_PARAM_NOTNONE));
//	        }
//	        log.info("查询用户黑白名单信息【理财产品渠道：{}，用户ID：{} 】",param.getProductChannel(),param.getMemberid());
//	        try {
//	            Map<String, String> stringMap = resourceService.rBlackWhiteInfo(param.getProductChannel(), param.getMemberid());
//	            return ResponseResult.getOkResponse(stringMap);
//	        } catch (Exception e) {
//	            log.error("查询用户黑白名单信息报错！",e);
//	        }
	        return ResponseResult.getOkResponse(bean);
	        //return ResponseResult.getErrorResponse(ReturnCode.DB_OPERATION_FAILURE, ReturnCode.getReturnMsg(ReturnCode.DB_OPERATION_FAILURE));
	    }
	
	

}
