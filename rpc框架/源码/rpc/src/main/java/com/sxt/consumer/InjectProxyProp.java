package com.sxt.consumer;

import java.lang.reflect.Field;
import java.util.List;

import com.sxt.anno.InjectProxy;
import com.sxt.core.context.BeanCup;

public class InjectProxyProp {

	
	public static void injectProxys(List<Class<?>> clazzs) {
		for (Class<?> clazz : clazzs) {
			injectProxyProp(clazz);
		}
	}

	/**
	 * 注入一个代理对象
	 * @param clazz
	 *    实现类的的名称
	 */
	public static void injectProxyProp(Class<?> clazz) {
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			InjectProxy injectProxy = field.getAnnotation(InjectProxy.class);
			if(injectProxy!=null) {// 此处需要注入代理对象
				Object filedValue = null ;
				String id = injectProxy.id();
				if(!id.equals("")) {
					filedValue = BeanCup.getObject(id);
				}

				if(filedValue==null) {
					Class<?> type = field.getType();
					// 创建对象的代理对象
					filedValue = ProxyFactory.createProxy(type);
				}
				field.setAccessible(true);

				// 获取要注入的对象 clazz 是对象的class ，并不是该对象接口的clazz
				Object instance = BeanCup.getObject(clazz.getInterfaces()[0]);
				try {
					field.set(instance, filedValue);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
