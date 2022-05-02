package com.sxt.domain;

import java.io.Serializable;

/**
 * 给室友请求的封装体
 * @author CodeLab
 *
 */
public class Request implements Serializable{
  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String className;
    private String methodName;
    private Object[] args;
    
    public Request() {}
	public Request(String className, String methodName, Object[] args) {
		super();
		this.className = className;
		this.methodName = methodName;
		this.args = args;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public Object[] getArgs() {
		return args;
	}
	public void setArgs(Object[] args) {
		this.args = args;
	}
    
    
    
}
