package com.lquan.ops.service.questionnaire.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lquan.ops.dao.TemplateMapper;
import com.lquan.ops.model.po.Template;
import com.lquan.ops.service.questionnaire.ITemplateServer;
import com.lquan.ops.util.constant.GlobalConstant;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service("templateServer")
public class TemplateServerImpl implements ITemplateServer {
	
	@Autowired
	private TemplateMapper templateMapper;

	/**
	 * 创建并返回主键
	 */
	@Override
	public Template createTemplate(Template template) {
		template.setID(null);
		template.setActive(GlobalConstant.ACTIVE_YES);
		template.setCreatedAt(new Date());
		templateMapper.insertSelective(template);
		return template;
	}

	/**
	 * 查询问卷模版
	 * @param template
	 * @return
	 */
	@Override
	public List<Template> searchTemplate(Template template) {
		return templateMapper.selectByConfidtion(template);
	}

}
