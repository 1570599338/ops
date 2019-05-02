package com.lquan.ops.model.back.resp.questionnaire;

import java.util.List;

import com.lquan.ops.model.back.po.QueOption;
import com.lquan.ops.model.back.po.Question;

import lombok.Data;

@Data
public class QuestionResp extends Question{
	  private List<QueOption> Options;

}
