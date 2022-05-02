package com.sxt.core.context;

import java.util.Map;
import java.util.TreeMap;

import com.sxt.core.label.Label;

/**
 * 对象的容器
 * @author CodeLab
 *
 */
public class BeanCup {

	public static Map<Label,Object> iocs = new TreeMap<>();
	
	/**
	 * 往容器里面放一个对象
	 * @param label
	 * 对象的标签
	 * @param object
	 * 对象
	 */
	public static void putObject(Label label,Object object) {
		iocs.put(label, object);
	}
	
	
	public static Object getObject(String id) {
		return iocs.get(Label.Id(id));
	}
	
	public static Object getObject(Class<?> interfaces) {
		return iocs.get(Label.Interfaces(interfaces));
	}
	
}
