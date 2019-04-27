package com.lquan.response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author lquan
 *
 */
public class ReturnCode {
    /**操作成功*/
    public static String SUCCESS = "000";
    /**操作成功*/
    public static String SUCCESS_NEW = "000000";
    /**服务器异常*/
    public static String ERROR = "001";
    /**请求参数不全,或者不完整*/
    public static String REQUEST_PARAM_ERROR="002";
    /**数据库操作失败*/
    public static String DB_OPERATION_FAILURE = "003";
    /**非法操作*/
    public static String FORBIDDEN_OPERATION = "004";
    /**参数为空**/
    public static String REQUEST_PARAM_NONE="998";
    /**参数部分为空**/
    public static String REQUEST_PARAM_NOTNONE="997";
    /**参数接口验证不通过**/
    public static String REQUEST_PARAM_FAIL="999";
    /**参数接口版本不存在**/
    public static String REQUEST_PARAM_VERSION_FAIL="996";

    /**已有活动安排*/
    public static String HAVA_ERROR = "005";

    /**同步失败*/
    public static String TOAPP_ERROR = "006";

    /** 文件上传失败  */
    public static String FILE_UPLOAD_FAILURE = "100";
    /** 文件上传远端异常 */
    public static String FILE_UPLOAD_REMOTE_ERROR = "101";

    /** 接口返回不成功*/
    public static String INTERFACE_NOT_SUCCESS="102";

    public static String INTERFACE_ERROR="103";

    public static String DATA_NOT_EXIS="104";

    public static String DATA_MORE="105";

  
  

    public static String getReturnMsg(String code){
        return codeMap.get(code);
    }

    public static Map<String, String> codeMap = new HashMap<String, String>();
    public static ArrayList<String> ignoreUrls = new ArrayList<String>();

    public static void initErrorMap() {
        codeMap.put(SUCCESS, "操作成功");
        codeMap.put(ERROR, "操作失败");
        codeMap.put(REQUEST_PARAM_ERROR, "请求参数异常");
        codeMap.put(DB_OPERATION_FAILURE, "数据库操作失败");
        codeMap.put(REQUEST_PARAM_VERSION_FAIL, "参数接口版本不存在");//REQUEST_PARAM_VERSION_FAIL
        codeMap.put(FORBIDDEN_OPERATION, "非法操作,禁止操作");
        codeMap.put(FILE_UPLOAD_FAILURE, "文件上传失败");
        codeMap.put(FILE_UPLOAD_REMOTE_ERROR, "文件上传远端异常");
        codeMap.put(HAVA_ERROR, "已有活动安排");
        codeMap.put(TOAPP_ERROR, "同步APP数据失败,请找攻城狮协同解决");
        codeMap.put(INTERFACE_NOT_SUCCESS, "接口返回不成功");
        codeMap.put(INTERFACE_ERROR, "接口服务器异常");
        codeMap.put(DATA_NOT_EXIS, "数据不存在");
        codeMap.put(DATA_MORE, "包含多条数据");
        codeMap.put(REQUEST_PARAM_NONE, "参数为空");
        codeMap.put(REQUEST_PARAM_NOTNONE, "参数部分为空");
        codeMap.put(REQUEST_PARAM_FAIL, "参数接口验证不通过");
    }
    /**
     * 初始化应该被忽视的请求的url，<pre>忽视规则:<font color="red">当请求url包含忽视列表中某个字符串时，就判定为该忽视的url</font></pre>
     */
    public static void initIgnoreUrls(){
        ///所有不需要登陆的请求路劲都应该添加进来
//    	ignoreUrls.add("/showLogin");
    }
    static{
        initErrorMap();
        initIgnoreUrls();
    }
}
