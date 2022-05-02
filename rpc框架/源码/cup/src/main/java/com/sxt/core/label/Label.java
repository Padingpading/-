package com.sxt.core.label;

public class Label implements Comparable<Label>{

	/**
	 * 对象第一个标签，id
	 */
	private String id;

	/**
	 *  对象的第二个标签，接口
	 */
	private Class<?> interfaces;


	public static Label Id(String id) {
		Label label = new Label();
		label.id = id;
		return label;
	}

	public static Label Interfaces(Class<?> interfaces) {
		Label label = new Label();
		label.interfaces = interfaces;
		return label;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Class<?> getInterfaces() {
		return interfaces;
	}

	public void setInterfaces(Class<?> interfaces) {
		this.interfaces = interfaces;
	}

	@Override
	public int compareTo(Label o) {
		// id
		if(o.getId()!=null) {
			if(o.getId().equals(this.getId())) return 0;
		}
		// Interface 的属性
		if(o.getInterfaces()!=null) {
			if(o.getInterfaces().equals(this.getInterfaces())) return 0;
		}
		
		return -1;
	}
}
