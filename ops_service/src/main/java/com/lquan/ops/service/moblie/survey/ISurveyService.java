package com.lquan.ops.service.moblie.survey;

import java.util.List;

import com.lquan.ops.model.mobile.resp.SurveyResp;

public interface ISurveyService {
	
	/**
	 * 答卷机会里的可答问卷
	 * @param memberid
	 * @param state
	 * @return
	 */
	List<SurveyResp> searchSurvey(Integer memberid,Integer state);

}
