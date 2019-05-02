package com.lquan.ops.model.back.req.questionnaire;

import java.util.List;

import com.lquan.ops.model.back.po.QueOption;
import com.lquan.ops.model.back.po.Question;

import lombok.Data;

@Data
public class QuestionReq extends Question{
	private List<QueOption> options;

}
