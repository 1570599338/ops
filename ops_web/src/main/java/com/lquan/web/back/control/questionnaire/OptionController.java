package com.lquan.web.back.control.questionnaire;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lquan.ops.model.back.po.Orders;
import com.lquan.ops.model.back.po.QueOption;
import com.lquan.ops.service.back.questionnaire.IOptionServer;
import com.lquan.response.ResponseJson;
import com.lquan.response.ResponseResult;
import com.lquan.response.ReturnCode;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping(value="/option")
public class OptionController {

	@Autowired
	public IOptionServer optionServer;
	
	
	/**
	 * 
	 * @param jsonObject
	 * @param request
	 * @param response
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping(value="/update")
	@ResponseBody
	public   ResponseJson updateTitle(@RequestBody QueOption record,HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {
			// String userName="test";
			 optionServer.updateOption(record);
			return ResponseResult.getOkResponse(record);
		} catch (Exception e) {
			log.error("查询问卷的模版数据异常:{}",e);
		}
	    return ResponseResult.getErrorResponse(ReturnCode.DB_OPERATION_FAILURE, ReturnCode.getReturnMsg(ReturnCode.DB_OPERATION_FAILURE));
	 }
	
	/**
	 * 移动
	 * @param orderList
	 * @param request
	 * @param response
	 * @return 
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/move")
	public ResponseJson toQuestMove(@RequestBody List<Orders> orderList,HttpServletRequest request, HttpServletResponse response) throws Exception{
		String user ="usename";
		try {
			this.optionServer.moveQueOPtion(orderList,user);
			return ResponseResult.getOkResponse(orderList);
		} catch (Exception e) {
			log.error("移动选项数据异常:{}",e);
		}
	    return ResponseResult.getErrorResponse(ReturnCode.DB_OPERATION_FAILURE, ReturnCode.getReturnMsg(ReturnCode.DB_OPERATION_FAILURE));
	 }
	
	
	/**
	 * 添加问题和选项
	 * @param qu
	 * @param request
	 * @param response
	 * @return 
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/create")
	public ResponseJson toLogin(@RequestBody QueOption option,HttpServletRequest request, HttpServletResponse response) throws Exception{
		String user ="usename";
		try {
			QueOption  bean = this.optionServer.createOPtion(option,user);
			return ResponseResult.getOkResponse(bean);
		} catch (Exception e) {
			log.error("移动选项数据异常:{}",e);
		}
	    return ResponseResult.getErrorResponse(ReturnCode.DB_OPERATION_FAILURE, ReturnCode.getReturnMsg(ReturnCode.DB_OPERATION_FAILURE));
	 }
	
	/**
	 * 添加问题和选项
	 * @param qu
	 * @param request
	 * @param response
	 * @return 
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/batchCreate")
	public ResponseJson batchCreate(@RequestBody List<QueOption> list,HttpServletRequest request, HttpServletResponse response) throws Exception{
		String user ="usename";
		try {
			List<QueOption>  result = this.optionServer.batchCreateOPtion(list,user);
			return ResponseResult.getOkResponse(result);
		} catch (Exception e) {
			log.error("移动选项数据异常:{}",e);
		}
	    return ResponseResult.getErrorResponse(ReturnCode.DB_OPERATION_FAILURE, ReturnCode.getReturnMsg(ReturnCode.DB_OPERATION_FAILURE));
	 }
	
	
	/**
	 * 删除数据
	 * @param option
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/delete")
	public   ResponseJson deleteOption(@RequestBody  QueOption option,HttpServletRequest request, HttpServletResponse response) throws Exception{
		String user ="usename";
		try {
			QueOption  bean = this.optionServer.deleteOption(option,user);
			return ResponseResult.getOkResponse(bean);
		} catch (Exception e) {
			log.error("删除选项数据异常:{}",e);
		}
	    return ResponseResult.getErrorResponse(ReturnCode.DB_OPERATION_FAILURE, ReturnCode.getReturnMsg(ReturnCode.DB_OPERATION_FAILURE));
	 }
}
