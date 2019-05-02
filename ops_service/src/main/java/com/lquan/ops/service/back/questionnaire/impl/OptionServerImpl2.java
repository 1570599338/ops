package com.lquan.ops.service.back.questionnaire.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lquan.ops.dao.ProjectMapper;
import com.lquan.ops.dao.QueOptionMapper;
import com.lquan.ops.dao.QuestionMapper;
import com.lquan.ops.dao.TemplateMapper;
import com.lquan.ops.model.back.po.QueOption;
import com.lquan.ops.service.back.questionnaire.IOptionServer2;


@Service(value="optionServer2")
public class OptionServerImpl2 implements IOptionServer2 {

	@Autowired
	private ProjectMapper projectMapper;
	
	@Autowired
	private QueOptionMapper queOptionMapper;
	
	@Autowired
	private QuestionMapper questionMapper;
	
	@Autowired
	private TemplateMapper templateMapper;
	
	
	/**
	 * 对选项进行排序
	 * @param firstID
	 * @param firstDispIndex
	 * @return
	 * @throws Exception
	 */
	@Override
	@Transactional
	public Boolean moveOPtion(Long firstID,int firstDispIndex) throws Exception{
//		StringBuffer sql = new StringBuffer();
//		sql.append(" update queoption set dispIndex =?  where pk_id=").append(firstID);
//		int a = commonDao.update(sql.toString(),new Object[]{firstDispIndex});
//		
//		if(a>0)
//			return true;
//		return false;
		QueOption record = new QueOption();
		record.setID(firstID.intValue());
		record.setDispIndex(firstDispIndex);
		queOptionMapper.updateByPrimaryKey(record);
		return true;
	}
	
	
	/**
	 * 插入选项数据
	 * @param arg
	 * @return
	 * @throws Exception
	 */
	@Override
	public Boolean createOPtion(QueOption record) throws Exception {
//		StringBuffer sql = new StringBuffer();
//		sql.append("insert into queoption(pk_id,id,CreatedBy,UpdatedBy,QuestionID,Code,Title,ImageUrl,VideoUrl,[Open],Help,DispIndex,BlankType,BlankMax,BlankMin,BlankOptional,Value,Exclusive,ThumbUrl,BlankRows,BlankCols,Orientation,ShowValue,ShowTip,ShowCancel,SelectionMax,SelectionMin,Active,CreatedAt,UpdatedAt) ");
//		sql.append(" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,getdate(),getdate())");
//		int a = commonDao.update(sql.toString(), arg);
		
		queOptionMapper.insertSelective(record);
		return true;
	}
	
	/**
	 * 删除选项
	 * @param ID 选项的主键
	 * @return
	 * @throws Exception
	 */
	@Override
	public Boolean deleteOption(Long ID) throws Exception{
//		StringBuffer sql = new StringBuffer();
//		sql.append(" delete from queoption   where pk_id=").append(ID);
//		int a = commonDao.update(sql.toString());
//		if(a>0)
//		return false;
		queOptionMapper.deleteByPrimaryKey(ID.intValue());
		return true;
		
	}
	
	/**
	 * 更新选项内容
	 * @param arg
	 * @return
	 * @throws Exception
	 */
	@Override
	public Boolean updateOption(QueOption record) throws Exception {
//		StringBuffer sql = new StringBuffer();
//		sql.append(" update queoption set updatedBy=?,QuestionID=?,code=?,title=?,imageUrl=?,videoUrl=?,[open]=?,help=?,dispIndex=?,blankType=?,blankMax=?,blankMin=?,blankOptional=?,value=?,exclusive=?,thumbUrl=?,blankRows=?,blankCols=?,orientation=?,showValue=?,showTip=?,showCancel=?,selectionMax=?,selectionMin=?,active=?,UpdatedAt=getdate()  where pk_id=?");
//		int a = commonDao.update(sql.toString(),arg);
		
		queOptionMapper.updateByPrimaryKeySelective(record);
		return true;
	}
	
}
