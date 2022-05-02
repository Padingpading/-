package com.sxt.core.utils;

import java.util.List;

import com.sxt.core.anno.AutoBuilder;
import com.sxt.core.context.BeanCup;
import com.sxt.core.label.Label;

/**
 * 用来创建对象的工具
 * @author CodeLab
 *
 */
public class BeanFactory {

	public static void createObjects(List<Class<?>> clazzs) {
		for (Class<?> clazz : clazzs) {
			createObject(clazz);
		}
	}

	public static void createObject(Class<?> clazz) {
		AutoBuilder builder = clazz.getAnnotation(AutoBuilder.class);
		if(builder!=null) {
			String name = builder.name();
			if(name.equals("")) {
				String objectName = clazz.getSimpleName();
				String firstChar = objectName.substring(0, 1);
				name = objectName.replaceFirst(firstChar, firstChar.toLowerCase());
			}
			// 构建对象的标签
			Label label = new Label();
			label.setId(name);
			label.setInterfaces(clazz.getInterfaces()[0]);

			//创建对象
			Object obj = null;
			try {
				obj = clazz.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
			// 将对象放入容器里面
			BeanCup.putObject(label, obj);
		}
	}
}
