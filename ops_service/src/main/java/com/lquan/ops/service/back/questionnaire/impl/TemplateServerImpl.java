package com.lquan.ops.service.back.questionnaire.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lquan.ops.dao.TemplateMapper;
import com.lquan.ops.model.back.po.Template;
import com.lquan.ops.service.back.questionnaire.ITemplateServer;
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
		log.info("创建问卷模版");
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

	/**
	 * 修改
	 * @param template
	 * @return
	 */
	@Override
	public Template updateTemplate(Template template) {
		templateMapper.updateByPrimaryKeySelective(template);
		return template;
	}

	/**
	 * 删除
	 * @param template
	 * 
	 */
	@Override
	public void deleteTemplate(Template template) {
		templateMapper.deleteByPrimaryKey(template.getID());
	}

	/**
	 * 根据主键查询
	 */
	@Override
	public Template getTemplate(Template template) {
		return templateMapper.selectByPrimaryKey(template.getID());
	}

}
