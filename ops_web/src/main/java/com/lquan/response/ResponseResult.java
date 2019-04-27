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
public class ResponseResult {
    public static ResponseJson getOkResponse(){
        ObjectResponse objectResponse = new ObjectResponse();
        objectResponse.setCode(ReturnCode.SUCCESS);
        objectResponse.setMessage(ReturnCode.getReturnMsg(ReturnCode.SUCCESS));
        return objectResponse;
    }

    public static ResponseJson getOkResponse(Object obj){
        ObjectResponse objectResponse = new ObjectResponse();
        objectResponse.setCode(ReturnCode.SUCCESS);
        objectResponse.setMessage(ReturnCode.getReturnMsg(ReturnCode.SUCCESS));
        objectResponse.setResp(obj);
        return objectResponse;
    }
    public static ResponseJson getOkResponse(Object obj,Integer total){
    		ObjectResponsePage objectResponse = new ObjectResponsePage();
        objectResponse.setCode(ReturnCode.SUCCESS);
        objectResponse.setMessage(ReturnCode.getReturnMsg(ReturnCode.SUCCESS));
        objectResponse.setTotalSize(total);
        objectResponse.setResp(obj);
        return objectResponse;
    }
    public static ResponseJson getErrorResponse(String code,String message){
        EmptyResponse emptyResponse = new EmptyResponse();
        emptyResponse.setCode(code);
        emptyResponse.setMessage(message);
        return emptyResponse;
    }
    public static ResponseJson getOkListResponse(List list){
        ObjectResponse objectResponse = new ObjectResponse();
        objectResponse.setCode(ReturnCode.SUCCESS);
        objectResponse.setMessage(ReturnCode.getReturnMsg(ReturnCode.SUCCESS));
        Map<String,Object> result = new HashMap<String,Object>();
        objectResponse.setResp(result);
        result.put("result",list);
        return objectResponse;
    }

    public static ResponseJson getPageResponse(PageInfo page) {
        ObjectResponse objectResponse = new ObjectResponse();
        objectResponse.setCode(ReturnCode.SUCCESS);
        objectResponse.setMessage(ReturnCode.getReturnMsg(ReturnCode.SUCCESS));
        Map<String,Object> result = new HashMap<String,Object>();
        objectResponse.setResp(result);
        result.put("result",page.getList());
        result.put("currentPage",page.getPageNum());
        result.put("pageSize",page.getPageSize());
        result.put("totalRowSize",page.getTotal());
        result.put("pageCount",page.getPages());
        return objectResponse;
    }
    

    
    public static ResponseJson getOkResponseForData(Object obj){
    	ObjectResponseNew objectResponse = new ObjectResponseNew();
        objectResponse.setCode(ReturnCode.SUCCESS);
        objectResponse.setMessage(ReturnCode.getReturnMsg(ReturnCode.SUCCESS));
        objectResponse.setData(obj);
        return objectResponse;
    }
    
    public static ResponseJson getSuccessResponse(Object obj){
        ObjectResponse objectResponse = new ObjectResponse();
        objectResponse.setCode(ReturnCode.SUCCESS_NEW);
        objectResponse.setMessage(ReturnCode.getReturnMsg(ReturnCode.SUCCESS_NEW));
        objectResponse.setResp(obj);
        return objectResponse;
    }
    
    
    public static ResponseJson getOkResponseSixZero(Object obj){
        ObjectResponse objectResponse = new ObjectResponse();
        objectResponse.setCode(ReturnCode.SUCCESS_NEW);
        objectResponse.setMessage(ReturnCode.getReturnMsg(ReturnCode.SUCCESS));
        objectResponse.setResp(obj);
        return objectResponse;
    }

}
