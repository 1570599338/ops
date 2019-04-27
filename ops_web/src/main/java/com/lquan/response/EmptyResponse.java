package com.lquan.response;
/**
 * 返回对象， 格式：
 * <pre>code:xxxxxx<br>
 * message:xxxx<br>
 * </pre>
 */
public class EmptyResponse extends ResponseJson{
	
	private static final long serialVersionUID = 1L;
	private String code;
	private String message;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
