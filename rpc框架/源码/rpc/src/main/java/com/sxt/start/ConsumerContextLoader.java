package com.sxt.start;

import java.util.ArrayList;
import java.util.List;

import com.sxt.consumer.InjectProxyProp;
import com.sxt.core.utils.BasePackageUtil;
import com.sxt.core.utils.BeanFactory;
import com.sxt.core.utils.InjectPropUntils;

public class ConsumerContextLoader {

	public static void  initdConsumer(String packageName) {

		// 1 包扫描
		// 2 创建对象
		// 3注入属性
		// 4 注入代理对象的属性
		String[] packages = packageName.split(",");
		List<Class<?>> clazzs = new ArrayList<>();

		for (String pack : packages) {
			clazzs.addAll(BasePackageUtil.scanPackage(pack));
		}
		BeanFactory.createObjects(clazzs);
		InjectPropUntils.InjectPorps(clazzs);
		InjectProxyProp.injectProxys(clazzs);
	}


	// 要先启动容器
	// 创建代理对象并注入
}
