package com.lquan.ops.model.mobile.resp;


import lombok.Data;

@Data
public class SurveyResp {
	
	// 提交次数
	private Integer commentCount;//		number	@mock=$order(0,0,0,0)
	private Integer dedicated;//		number	@mock=$order(1,1,1,1)
	// 答题人数
	private Integer involverCount;//		number	@mock=$order(3,2,3,42)
	private Integer isFirst;//		number	@mock=$order(254,254,254,254)
	private Integer latentMember;//		number	@mock=$order(2,2,2,2)
	// 喜欢人数
	private Integer likedCount;//		number	@mock=$order(0,0,0,0)
	private Integer memberType;//		number	@mock=$order(1,1,1,1)
	// 项目
	private ProductResp  project;//		object	
	// 奖励
	private RewardMResp reward;//		object	
	// 分享次数
	private Integer sharedCount;//		number	@mock=$order(0,0,0,0)
	//问卷
	private TemplateMResp template;//

}
