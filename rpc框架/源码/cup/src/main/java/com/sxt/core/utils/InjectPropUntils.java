package com.sxt.core.utils;

import java.lang.reflect.Field;
import java.util.List;

import com.sxt.core.anno.Inject;
import com.sxt.core.context.BeanCup;

public class InjectPropUntils {

	public static void InjectPorps(List<Class<?>> clazzs) {
		for (Class<?> clazz : clazzs) {
			InjectPorps(clazz);
		}
	}

	public static void InjectPorps(Class<?> clazz) {
		// 得到所有的属性
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			Object prop = null ;
			Inject inject = field.getAnnotation(Inject.class);
			if(inject!=null) {// 注入该属性
				String id = inject.id();
				///////////////获取要注入的该属性的值
				// 通过id 获取要注入的属性的值
				if(!id.equals("")) {// 先通过id 来注入
					prop = BeanCup.getObject(id);// prop可能为null
				}
				// 通过类型来获取要注入的属性的值
				if(prop==null) {
					prop = BeanCup.getObject(field.getType());
				}
	           ///////////////注入的该属性的值已经获取成功
				
			 //////////给对象设置属性，该对象此时已经在容器里里面创建完成了/////////////////
				
				// 获取要设置属性的对象
				Object object = BeanCup.getObject(clazz.getInterfaces()[0]);
				field.setAccessible(true);
				try {
					// 设置属性
					field.set(object,prop);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				 //////////对象的值设置完毕/////////////////
			}
		}
	}
}
