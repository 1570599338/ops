package com.lquan.response;

/**
 * 
 * @author lquan
 *
 * @param <T>
 */
public class ObjectResponsePage<T> extends ObjectResponse<T>{
	private static final long serialVersionUID = 5675434297181943274L;
	
	private Integer totalSize;

	public Integer getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}

	
}
