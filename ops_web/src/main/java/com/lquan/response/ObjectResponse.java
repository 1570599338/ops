package com.lquan.response;

/**
 * 
 * @author lquan
 *
 * @param <T>
 */
public class ObjectResponse<T> extends ResponseJson{
	private static final long serialVersionUID = 5675434297181943274L;
	private String code;
	private String message;
	private T resp;
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
	public T getResp() {
		return resp;
	}
	public void setResp(T resp) {
		this.resp = resp;
	}
	
	
}
