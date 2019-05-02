package com.lquan.web.mobile.control.questionnaire;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lquan.ops.model.back.po.Template;
import com.lquan.ops.model.mobile.resp.SurveyResp;
import com.lquan.ops.service.moblie.survey.ISurveyService;
import com.lquan.response.ResponseJson;
import com.lquan.response.ResponseResult;
import com.lquan.response.ReturnCode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/survey")
public class SurveyControl {
	
	@Autowired
	private ISurveyService surveyService;
	
	/**
	 * 获取答卷机会
	 * @param memberid
	 * @param state
	 * @param request
	 * @param response
	 * @return
	 */
	 @ResponseBody
	 @RequestMapping("/search")
	 public ResponseJson searchSurvey(Integer memberid,Integer state,HttpServletRequest request, HttpServletResponse response){
		 try {
			String userName = "test";
			List<SurveyResp> list= surveyService.searchSurvey(memberid,state);
			return ResponseResult.getOkResponse(list);
		} catch (Exception e) {
			log.error("获取答卷机会异常:{}",e);
		}
	        return ResponseResult.getErrorResponse(ReturnCode.DB_OPERATION_FAILURE, ReturnCode.getReturnMsg(ReturnCode.DB_OPERATION_FAILURE));
	 }

}
