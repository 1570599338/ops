package com.lquan.response;

import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author lquan
 *
 */
public class ResponseResultNew {
    public static ResponseJson getOkResponse(){
        ObjectResponseNew objectResponse = new ObjectResponseNew();
        objectResponse.setCode(ReturnCode.SUCCESS_NEW);
        objectResponse.setMessage(ReturnCode.getReturnMsg(ReturnCode.SUCCESS_NEW));
        return objectResponse;
    }

    public static ResponseJson getOkResponse(Object obj){
    	ObjectResponseNew objectResponse = new ObjectResponseNew();
        objectResponse.setCode(ReturnCode.SUCCESS_NEW);
        objectResponse.setMessage(ReturnCode.getReturnMsg(ReturnCode.SUCCESS_NEW));
        objectResponse.setData(obj);
        return objectResponse;
    }
    public static ResponseJson getOkResponse(Object obj,Integer total){
    		ObjectResponsePageNew objectResponse = new ObjectResponsePageNew();
        objectResponse.setCode(ReturnCode.SUCCESS_NEW);
        objectResponse.setMessage(ReturnCode.getReturnMsg(ReturnCode.SUCCESS_NEW));
        objectResponse.setTotalSize(total);
        objectResponse.setData(obj);
        return objectResponse;
    }
    public static ResponseJson getErrorResponse(String code,String message){
        EmptyResponse emptyResponse = new EmptyResponse();
        emptyResponse.setCode(code);
        emptyResponse.setMessage(message);
        return emptyResponse;
    }
    public static ResponseJson getOkListResponse(List list){
        ObjectResponseNew objectResponse = new ObjectResponseNew();
        objectResponse.setCode(ReturnCode.SUCCESS_NEW);
        objectResponse.setMessage(ReturnCode.getReturnMsg(ReturnCode.SUCCESS_NEW));
        Map<String,Object> result = new HashMap<String,Object>();
        objectResponse.setData(result);
        result.put("result",list);
        return objectResponse;
    }

    public static ResponseJson getPageResponse(PageInfo page) {
        ObjectResponseNew objectResponse = new ObjectResponseNew();
        objectResponse.setCode(ReturnCode.SUCCESS_NEW);
        objectResponse.setMessage(ReturnCode.getReturnMsg(ReturnCode.SUCCESS_NEW));
        Map<String,Object> result = new HashMap<String,Object>();
        objectResponse.setData(result);
        result.put("result",page.getList());
        result.put("currentPage",page.getPageNum());
        result.put("pageSize",page.getPageSize());
        result.put("totalRowSize",page.getTotal());
        result.put("pageCount",page.getPages());
        return objectResponse;
    }
}
