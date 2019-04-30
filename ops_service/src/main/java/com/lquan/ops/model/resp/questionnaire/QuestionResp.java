package com.lquan.ops.model.resp.questionnaire;

import java.util.List;

import com.lquan.ops.model.po.QueOption;
import com.lquan.ops.model.po.Question;

import lombok.Data;

@Data
public class QuestionResp extends Question{
	 private List<QueOption> Options;

}
