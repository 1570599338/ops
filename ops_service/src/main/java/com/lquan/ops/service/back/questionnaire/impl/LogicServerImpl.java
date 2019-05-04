package com.lquan.ops.service.back.questionnaire.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lquan.ops.dao.LogicMapper;
import com.lquan.ops.model.po.Logic;
import com.lquan.ops.service.back.questionnaire.ILogicServer;
import com.lquan.ops.util.constant.GlobalConstant;

@Service("logicServer")
public class LogicServerImpl implements ILogicServer{
	
	@Autowired
	private LogicMapper logicMapper;

	@Override
	public List<Logic> searchLogic(Byte type, Integer subjecttype, Integer exptype, Integer contextid) {
		Logic logic = new Logic();
		logic.setType(type);
		logic.setSubjectType(subjecttype);
		logic.setExpType(exptype);
		logic.setQuestionID(contextid);
		logic.setActive(true);
		List<Logic> list = logicMapper.selectByConfid(logic);
		return list==null?new ArrayList<Logic>():list;
	}

	/**
	 * 保存逻辑
	 * @param type
	 * @param subjecttype
	 * @param exptype
	 * @param contextid
	 * @return
	 */
	@Override
	public List<Logic> submitLogic(Byte type, Integer subjecttype, Integer exptype, Integer contextid,List<Logic> list,String userName) {
		Logic logic = new Logic();
		logic.setType(type);
		logic.setSubjectType(subjecttype);
		logic.setExpType(exptype);
		logic.setQuestionID(contextid);
		logicMapper.deleteBeforeSubmit(logic);
		List<Logic> listTem = new ArrayList<>();
		for(Logic record:list) {
			record.setCreatedBy(userName);
			record.setActive(GlobalConstant.ACTIVE_YES);
			record.setCreatedAt(new Date());
			logicMapper.insertSelective(record);
			listTem.add(record);
			
		}
		
		return listTem;
	}

}
