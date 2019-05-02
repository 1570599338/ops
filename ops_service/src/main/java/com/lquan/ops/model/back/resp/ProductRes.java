package com.lquan.ops.model.back.resp;

import lombok.Data;

@Data
public class ProductRes {
	private String subSys;//: 'wesurvey',
	private Integer  repID;//: repID,
     private String  isQuery;//: '1',
     private String  dispType;//: '12',
     private String  perRows;//: '2000'

}
