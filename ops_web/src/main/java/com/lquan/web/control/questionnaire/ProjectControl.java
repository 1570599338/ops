package com.lquan.web.control.questionnaire;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lquan.ops.model.po.Project;
import com.lquan.ops.model.resp.ProductRes;
import com.lquan.ops.service.questionnaire.IProjectServer;
import com.lquan.response.ResponseJson;
import com.lquan.response.ResponseResult;
import com.lquan.response.ReturnCode;

import lombok.extern.slf4j.Slf4j;

/**
 * 项目查询
 * @author lquan
 *
 */

@RestController
@Slf4j
@RequestMapping("/product")
public class ProjectControl {
	
	 @Autowired
	 private IProjectServer projectServer;
	
	/**
	 * 查询数据
	 * @param param
	 * @param request
	 * @param response
	 * @return
	 */
	 @ResponseBody
	 @RequestMapping("/allDate")
	 public ResponseJson allDate(@RequestBody ProductRes param,HttpServletRequest request, HttpServletResponse response){
		 try {
			 log.info("查询参数:{}",param.toString());
			 List<Project> bean= projectServer.selectAllProduct(null);

			 return ResponseResult.getOkResponse(bean);
		} catch (Exception e) {
			log.error("添加问卷模版:{}",e);
		}
	        return ResponseResult.getErrorResponse(ReturnCode.DB_OPERATION_FAILURE, ReturnCode.getReturnMsg(ReturnCode.DB_OPERATION_FAILURE));
	 }

}
