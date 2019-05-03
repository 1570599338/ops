package com.lquan.ops.service.back.questionnaire.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lquan.ops.dao.LogicMapper;
import com.lquan.ops.dao.QueOptionMapper;
import com.lquan.ops.dao.QuestionMapper;
import com.lquan.ops.dao.TemplateMapper;
import com.lquan.ops.model.back.po.Orders;
import com.lquan.ops.model.back.po.QueOption;
import com.lquan.ops.model.back.po.Question;
import com.lquan.ops.model.back.req.questionnaire.QuestionReq;
import com.lquan.ops.model.back.resp.questionnaire.QuestionResp;
import com.lquan.ops.model.po.Logic;
import com.lquan.ops.service.back.questionnaire.ILogicServer;
import com.lquan.ops.service.back.questionnaire.IQuestionServer;
import com.lquan.ops.util.constant.GlobalConstant;



@Service(value="questionServer")
public class QuestionServerImpl implements IQuestionServer {
	
	@Autowired
	private QuestionMapper questionMapper;
	
	@Autowired
	private QueOptionMapper queOptionMapper;
	
	@Autowired
	private TemplateMapper templateMapper;
	
	@Autowired
	private LogicMapper logicMapper;
	
	
	/**
	 * 创建题目并返回题目
	 */
	@Override
	public  QuestionReq createQuestion(QuestionReq record, String user){
		record.setID(null);
		record.setCreatedAt(new Date());
		record.setCreatedBy(user);
		record.setActive(GlobalConstant.ACTIVE_YES);
		questionMapper.insertSelective(record);
		
		List<QueOption> optionList = record.getOptions();
		List<QueOption> temOptionList = new ArrayList<QueOption>();
		for(QueOption bean:optionList) {
			bean.setID(null);
			bean.setQuestionID(record.getID());
			bean.setActive(GlobalConstant.ACTIVE_YES);
			bean.setCreatedAt(new Date());
			bean.setCreatedBy(user);
			queOptionMapper.insertSelective(bean);
			temOptionList.add(bean);
		}
		record.setOptions(temOptionList);
		
		return record;
	}
//	/**
//	 * 插入题目
//	 * @param arg
//	 * @return
//	 * @throws Exception
//	 */
//	@Override
//	@Transactional
//	public Boolean createQuestion(Object[] arg) throws Exception{
//		StringBuffer sql = new StringBuffer();
//		sql.append("insert into question( pk_id,ID,CreatedBy,UpdatedBy,TemplateID,Type,Number,Title,ImageUrl,VideoUrl,Optional,Help,Layout,DispIndex,SelectionMax,SelectionMin,RowDisordered,MatrixPivot,RowLastFixed,ColDisordered,ColLastFixed,ColumnCount,BusinessType,ScoreType,RowReverse,ColReverse,ChartType,Active,CreatedAt, UpdatedAt) ");
//		sql.append(" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,getdate(),getdate())");
//		int a = commonDao.update(sql.toString(), arg);
//		return true;
//	}
//
//	
//	/**
//	 * 插入选项数据
//	 * @param arg
//	 * @return
//	 * @throws Exception
//	 */
//	@Override
//	public Boolean createOPtion(Object[] arg) throws Exception {
//		StringBuffer sql = new StringBuffer();
//		sql.append("insert into queoption(pk_id,id,CreatedBy,UpdatedBy,QuestionID,Code,Title,ImageUrl,VideoUrl,[Open],Help,DispIndex,BlankType,BlankMax,BlankMin,BlankOptional,Value,Exclusive,ThumbUrl,BlankRows,BlankCols,Orientation,ShowValue,ShowTip,ShowCancel,SelectionMax,SelectionMin,Active,CreatedAt,UpdatedAt) ");
//		sql.append(" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,getdate(),getdate())");
//		int a = commonDao.update(sql.toString(), arg);
//		return true;
//	}
//
	/**
	 * 删除题目
	 */
	@Override
	public Question deleteQuestion(Question question,String user){
		question.setUpdatedAt(new Date());
		question.setUpdatedBy(user);
		question.setActive(GlobalConstant.ACTIVE_NO);
		questionMapper.updateByPrimaryKeySelective(question);
		return question;
	}

	/**
	 *  调换题目的顺序
	 * @param id 第一个题目的ID
	 * @param dispIndex 第一个题目的序号
	 * @return
	 * @throws Exception
	 */
	public List<Orders> moveQuestion(List<Orders> list) throws Exception {
		for(Orders order:list){
			Question question = new Question();
			question.setID(order.getId());
			question.setDispIndex(order.getDispIndex());
			questionMapper.updateByPrimaryKeySelective(question);
		}
		return list;
	}
	


	
	/**
	 * 题目的题目的相关的设置
	 * @param arg
	 * @return
	 * @throws Exception
	 */
	@Override
	public QuestionReq updateQuestion(QuestionReq record,String user) {
		
		questionMapper.updateByPrimaryKeySelective(record);
		List<QueOption> optionList = record.getOptions();
		for(QueOption option:optionList) {
			queOptionMapper.updateByPrimaryKeySelective(option);
		}
		return record;
	}
	
	
	//************************************************************************************
	
	/**
	 * 获取问卷所有数据
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<QuestionResp> searchQuestionList(Integer id) throws Exception {
		//
		List<Question> questionList =questionMapper.searchQuestionListByTemplateID(id);
		List<QuestionResp> list = new ArrayList<QuestionResp>();
		for(Question question :questionList){
			QuestionResp bean = new QuestionResp();
			BeanUtils.copyProperties(question, bean);
			Logic logic = new Logic();
			logic.setQuestionID(question.getID());
			List<Logic> logicList =logicMapper.selectByConfid(logic);
			bean.setLogicCount(logicList==null?null:logicList.size());
			List<QueOption> optionList = queOptionMapper.selectQueOptionByQuestionID(bean.getID());
			if(optionList!=null && optionList.size()>0){
				bean.setOptions(optionList);
				list.add(bean);
			}else {
				optionList = new ArrayList<>();
				bean.setOptions(optionList);
				list.add(bean);
			}
		}
		return list;
	}
//
//
//	/**
//	 * 获取问卷的选项
//	 * @param id
//	 * @return
//	 * @throws Exception
//	 */
//	@Override
//	public List<QueOption> getQueOption(Long id) throws Exception {
//		StringBuffer sql = new StringBuffer();
//		//sql.append("SELECT ID,QuestionID,Code,Title,ImageUrl,VideoUrl,[open],Help,DispIndex,BlankType,BlankMax,BlankMin,BlankOptional,Value,Exclusive,ThumbUrl,BlankRows,BlankCols,Orientation,ShowValue,ShowTip,ShowCancel,SelectionMax,SelectionMin,Active,CreatedAt,CreatedBy,UpdatedAt,UpdatedBy From queoption ");
//		sql.append("SELECT ID,QuestionID,Code,Title,ImageUrl,VideoUrl,[open],Help,DispIndex,BlankType,BlankMax,BlankMin,BlankOptional,Value,Exclusive,ThumbUrl,BlankRows,BlankCols,Orientation,ShowValue,ShowTip,ShowCancel,SelectionMax,SelectionMin,Active,CreatedAt,CreatedBy,UpdatedAt,UpdatedBy From queoption ");
//		sql.append(" Where QuestionID=").append(id);
//		sql.append(" order by DispIndex asc");
//		List<QueOption> optionList = this.commonDao.queryForPojoList(sql.toString(), QueOption.class);
//		return optionList;
//	}
//	
//	/**
//	 * 题目的题目的相关的设置
//	 * @param arg
//	 * @return
//	 * @throws Exception
//	 */
//	@Override
//	@Transactional
//	public Boolean updateQuestion(Object[] arg) throws Exception {
//		StringBuffer sql = new StringBuffer();
//		sql.append(" update question set TemplateID=?,Type=?,Number=?,Title=?,ImageUrl=?,VideoUrl=?,Optional=?,Help=?,Layout=?,DispIndex=?,SelectionMax=?,SelectionMin=?,RowDisordered=?,MatrixPivot=?,RowLastFixed=?,ColDisordered=?,ColLastFixed=?,ColumnCount=?,BusinessType=?,ScoreType=?,RowReverse=?,ColReverse=?,ChartType=?,UpdatedAt=getdate()  where pk_id=?");
//		int a = commonDao.update(sql.toString(),arg);
//		
//		if(a>0)
//			return true;
//		return false;
//		
//	}






	
}
