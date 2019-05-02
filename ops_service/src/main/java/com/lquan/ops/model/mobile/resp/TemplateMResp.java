package com.lquan.ops.model.mobile.resp;

import java.util.Date;

import lombok.Data;

@Data
public class TemplateMResp {
	//名称
	private String alias;//		string	@mock=A
	//介绍
	private String guide;//			string	@mock=<br>
	private Integer id;//			number	@mock=1075159118
	// 名字
	private String name;//			string	@mock=
	// 排序
	private Integer rank;//			number	@mock=1
	private Boolean signAgreement;//		boolean	@mock=true
	// 时间
	private Date updatedAt;//	

}
