package com.lquan.ops.service.questionnaire;

import com.lquan.ops.model.po.Template;

public interface ITemplateServer {
	
	/**
	 * 添加模版
	 * @param template
	 * @return
	 */
	public Template createTemplate(Template template);

}
