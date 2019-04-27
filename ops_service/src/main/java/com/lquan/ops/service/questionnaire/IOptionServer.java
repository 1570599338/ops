package com.lquan.ops.service.questionnaire;

import java.util.List;

import com.lquan.ops.model.po.Orders;
import com.lquan.ops.model.po.QueOption;


public interface IOptionServer {
	
	/**
	 * 插入选项数据
	 * @param arg
	 * @return
	 * @throws Exception
	 */
	public List<QueOption> createOPtion(List<QueOption> list,String userName) throws Exception;
	
	/**
	 * 删除选型
	 * @param option
	 * @return
	 * @throws Exception
	 */
	public QueOption deleteOption(QueOption option) throws Exception;
	
	
	/**
	 * 对选项进行排序
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public List<Orders> moveQueOPtion(List<Orders> list) throws Exception;
	

	/**
	 * 更新选项的内容
	 * @param arg
	 * @return
	 * @throws Exception
	 */
	public QueOption updateOption(QueOption option) throws Exception;
	
	
	
	
	/**
	 * 更新选项的内容
	 * @param arg
	 * @return
	 * @throws Exception
	 */
	public void updateOptionwithNo(QueOption option);

	


}
