package com.lquan.ops.service.back.questionnaire;

import java.util.List;

import com.lquan.ops.model.po.Logic;

public interface ILogicServer {
	
	/**
	 * 查询逻辑
	 * @param type
	 * @param subjecttype
	 * @param exptype
	 * @param contextid
	 * @return
	 */
	public List<Logic>  searchLogic(Byte type,Integer subjecttype,Integer exptype,Integer contextid);
	
	/**
	 * 保存逻辑
	 * @param type
	 * @param subjecttype
	 * @param exptype
	 * @param contextid
	 * @param record
	 * @return
	 */
	public List<Logic>  submitLogic(Byte type,Integer subjecttype,Integer exptype,Integer contextid,List<Logic> list,String userName);

}
