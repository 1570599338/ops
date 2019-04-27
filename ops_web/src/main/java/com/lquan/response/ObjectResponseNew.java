package com.lquan.response;

/**
 * 
 * @author lquan
 *
 * @param <T>
 */
public class ObjectResponseNew<T> extends ResponseJson{
	private static final long serialVersionUID = 5675434297181943274L;
	private String code;
	private String message;
	private T data;
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
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
