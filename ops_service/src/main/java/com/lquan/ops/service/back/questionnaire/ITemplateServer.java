package com.lquan.ops.service.back.questionnaire;

import java.util.List;

import com.lquan.ops.model.back.po.Template;

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
	
	/**
	 * 修改
	 * @param template
	 * @return
	 */
	public Template updateTemplate(Template template);
	
	/**
	 * 删除
	 * @param template
	 */
	public void deleteTemplate(Template template);
	
	/**
	 * 根据主键id查询模版
	 * @param template
	 * @return
	 */
	public Template getTemplate(Template template);
	
	

}
