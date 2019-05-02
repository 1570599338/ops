package com.lquan.ops.service.back.questionnaire.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lquan.ops.dao.ProjectMapper;
import com.lquan.ops.dao.QueOptionMapper;
import com.lquan.ops.dao.QuestionMapper;
import com.lquan.ops.dao.TemplateMapper;
import com.lquan.ops.model.back.po.Orders;
import com.lquan.ops.model.back.po.QueOption;
import com.lquan.ops.service.back.questionnaire.IOptionServer;
import com.lquan.ops.util.constant.GlobalConstant;


@Service(value="optionServer")
public class OptionServerImpl implements IOptionServer {

	@Autowired
	private ProjectMapper projectMapper;
	
	@Autowired
	private QueOptionMapper queOptionMapper;
	
	@Autowired
	private QuestionMapper questionMapper;
	
	@Autowired
	private TemplateMapper templateMapper;
	
	/**
	 * 插入选项数据
	 * @param arg
	 * @return
	 * @throws Exception
	 */
	@Override
	public QueOption createOPtion(QueOption option,String username){
		option.setID(null);
		option.setActive(GlobalConstant.ACTIVE_YES);
		option.setCreatedAt(new Date());
		option.setCreatedBy(username);
		queOptionMapper.insertSelective(option);
		return option;
	}
	
	/**
	 * 批量插入
	 * @param list
	 * @param userName
	 * @return
	 */
	public List<QueOption> batchCreateOPtion(List<QueOption> list,String userName){
		List<QueOption> result = new ArrayList<>();
		for(QueOption option:list) {
			option.setID(null);
			option.setActive(GlobalConstant.ACTIVE_YES);
			option.setCreatedAt(new Date());
			option.setCreatedBy(userName);
			queOptionMapper.insertSelective(option);
			result.add(option);
		}
		return result;
	}
	
	
	/**
	 * 对选项进行排序
	 * @param firstID
	 * @param firstDispIndex
	 * @return
	 * @throws Exception
	 */
	public List<Orders> moveQueOPtion(List<Orders> list,String user) throws Exception {
		for(Orders order:list){
			QueOption record  = new QueOption();
			record.setID(order.getId().intValue());
			record.setDispIndex(order.getDispIndex());
			queOptionMapper.updateByPrimaryKeySelective(record);
		}
		return list;
	}
	
	

	
	/**
	 * 删除选项
	 * @param ID 选项的主键
	 * @return
	 * @throws Exception
	 */
	@Override
	public QueOption deleteOption(QueOption option,String user){
		option.setActive(GlobalConstant.ACTIVE_NO);
		option.setUpdatedAt(new Date());
		option.setUpdatedBy(user);
		queOptionMapper.deleteByPrimaryKey(option.getID());
		
		return option;
	}
	
	
	/**
	 * 更新选项的内容
	 * @param arg
	 * @return
	 * @throws Exception
	 */
	@Override
	public QueOption updateOption(QueOption option) throws Exception {
		//StringBuffer sql = new StringBuffer();
		//sql.append(" update queoption set updatedBy=?,QuestionID=?,code=?,title=?,imageUrl=?,videoUrl=?,[open]=?,help=?,dispIndex=?,blankType=?,blankMax=?,blankMin=?,blankOptional=?,value=?,exclusive=?,thumbUrl=?,blankRows=?,blankCols=?,orientation=?,showValue=?,showTip=?,showCancel=?,selectionMax=?,selectionMin=?,active=?,UpdatedAt=getdate()  where pk_id=?");
		//sql.append(" update queoption set title=?,UpdatedAt=getdate()  where pk_id=?");
		//commonDao.update(sql.toString(),new Object[]{option.getTitle(),option.getId()});
		
		queOptionMapper.updateByPrimaryKeySelective(option);
		
		return option;
	}
	
	
	
// ******************************************************************************
	
	/**
	 * 更新选项内容
	 * @param arg
	 * @return
	 * @throws Exception
	 */
	@Override
	public void updateOptionwithNo(QueOption record){
//		StringBuffer sql = new StringBuffer();
//		sql.append(" update queoption set updatedBy=?,QuestionID=?,code=?,title=?,imageUrl=?,videoUrl=?,[open]=?,help=?,dispIndex=?,blankType=?,blankMax=?,blankMin=?,blankOptional=?,value=?,exclusive=?,thumbUrl=?,blankRows=?,blankCols=?,orientation=?,showValue=?,showTip=?,showCancel=?,selectionMax=?,selectionMin=?,active=?,UpdatedAt=getdate()  where pk_id=?");
//		int a = commonDao.update(sql.toString(),arg);
//		
//		if(a>0)
//			return true;
//		return false;
		
		queOptionMapper.updateByPrimaryKeySelective(record);
 		
	}



	
}
