package com.lquan.ops.service.questionnaire;

import java.util.List;

import com.lquan.ops.model.po.Template;

public interface ITemplateServer {
	
	/**
	 * 添加模版
	 * @param template
	 * @return
	 */
	public Template createTemplate(Template template);
	
	/**
	 * 查询问卷模版
	 * @param template
	 * @return
	 */
	public List<Template> searchTemplate(Template template);

}
