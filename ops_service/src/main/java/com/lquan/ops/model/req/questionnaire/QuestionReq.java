package com.lquan.ops.model.req.questionnaire;

import java.util.List;

import com.lquan.ops.model.po.QueOption;
import com.lquan.ops.model.po.Question;

import lombok.Data;

@Data
public class QuestionReq extends Question{
	private List<QueOption> options;

}
