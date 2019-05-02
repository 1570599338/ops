package com.lquan.ops.service.back.questionnaire;

import java.util.List;

import com.lquan.ops.model.back.po.Orders;
import com.lquan.ops.model.back.po.QueOption;


public interface IOptionServer {
	
	/**
	 * 插入选项数据
	 * @param arg
	 * @return
	 * @throws Exception
	 */
	public QueOption createOPtion(QueOption list,String userName);
	
	/**
	 * 删除选型
	 * @param option
	 * @return
	 * @throws Exception
	 */
	public QueOption deleteOption(QueOption option,String user) ;
	
	/**
	 * 批量插入
	 * @param list
	 * @param userName
	 * @return
	 */
	public List<QueOption> batchCreateOPtion(List<QueOption> list,String userName);
	
	
	/**
	 * 对选项进行排序
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public List<Orders> moveQueOPtion(List<Orders> list,String user) throws Exception;
	

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
