package com.lquan.ops.service.moblie.survey.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lquan.ops.dao.ProjectMapper;
import com.lquan.ops.dao.QueOptionMapper;
import com.lquan.ops.dao.QuestionMapper;
import com.lquan.ops.dao.TemplateMapper;
import com.lquan.ops.model.back.po.Project;
import com.lquan.ops.model.back.po.Template;
import com.lquan.ops.model.mobile.resp.ProductResp;
import com.lquan.ops.model.mobile.resp.RewardMResp;
import com.lquan.ops.model.mobile.resp.SurveyResp;
import com.lquan.ops.model.mobile.resp.TemplateMResp;
import com.lquan.ops.service.moblie.survey.ISurveyService;
import com.lquan.ops.util.constant.DateUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author lquan
 *
 */
@Slf4j
@Service("surveyService")
public class SurveyServiceImpl implements ISurveyService {
	
	@Autowired
	private ProjectMapper projectMapper;
	
	@Autowired
	private QueOptionMapper queOptionMapper;
	
	@Autowired
	private QuestionMapper questionMapper;
	
	@Autowired
	private TemplateMapper templateMapper;
	
	/**
	 * 答卷机会里的可答问卷
	 * @param memberid
	 * @param state
	 * @return
	 */
	@Override
	public List<SurveyResp> searchSurvey(Integer memberid, Integer state) {
		List<SurveyResp> list =new ArrayList<>();
		List<Project> productList =projectMapper.selectAllProduct(null);
		int count=0;
		for(Project project:productList) {
			ProductResp productRes=new ProductResp();
			BeanUtils.copyProperties(project, productRes);
			productRes.setId(project.getID());
			productRes.setEndDate(DateUtil.date2String(project.getEndDate(), DateUtil.YYYY_MM_DD));
			productRes.setBeginDate(DateUtil.date2String(project.getBeginDate(), DateUtil.YYYY_MM_DD));
			SurveyResp surveyResp= new SurveyResp();
			surveyResp.setCommentCount(0+count);
			surveyResp.setDedicated(1+count);
			surveyResp.setIsFirst(255);
			surveyResp.setLatentMember(2+count);
			surveyResp.setLikedCount(3+count);
			surveyResp.setMemberType(1+count);
			surveyResp.setSharedCount(4+count);
			surveyResp.setProject(productRes);
			surveyResp.setInvolverCount(3+count);
			RewardMResp reward =new RewardMResp();
			reward.setAmount(11);
			reward.setGiftcardCode(count);
			reward.setGiftcardName(null);
			reward.setTypeName(count%2==0?"礼金":"积分");
			reward.setTypeCode(count);
			surveyResp.setReward(reward);
			//
			Template record = new Template();
			record.setProjectID(1004609591);
			List<Template> templateList = templateMapper.selectByConfidtion(record);
			TemplateMResp tResp=new TemplateMResp();
			BeanUtils.copyProperties(templateList.get(count), tResp);
			tResp.setId(templateList.get(count).getID());
			surveyResp.setTemplate(tResp);
			list.add(surveyResp);
			count++;
		}
		// TODO Auto-generated method stub
		return list;
	}

}
