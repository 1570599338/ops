package com.lquan.ops.service.back.questionnaire;

import com.lquan.ops.model.back.po.QueOption;

public interface IOptionServer2 {
	
	/**
	 * 对选项进行排序
	 * @param firstID
	 * @param firstDispIndex
	 * @return
	 * @throws Exception
	 */
	public Boolean moveOPtion(Long firstID,int firstDispIndex) throws Exception;
	
	/**
	 * 插入选项数据
	 * @param arg
	 * @return
	 * @throws Exception
	 */
	public Boolean createOPtion(QueOption arg) throws Exception;
	
	/**
	 * 删除选项
	 * @param ID 选项的主键
	 * @return
	 * @throws Exception
	 */
	public Boolean deleteOption(Long ID) throws Exception;
	
	/**
	 * 更新选项的内容
	 * @param arg
	 * @return
	 * @throws Exception
	 */
	public Boolean updateOption(QueOption record) throws Exception;

}
