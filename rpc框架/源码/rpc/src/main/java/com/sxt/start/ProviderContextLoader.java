package com.sxt.start;

import java.util.ArrayList;
import java.util.List;

import com.sxt.core.utils.BasePackageUtil;
import com.sxt.core.utils.BeanFactory;
import com.sxt.core.utils.InjectPropUntils;
import com.sxt.provider.ServerPublish;

public class ProviderContextLoader {

	public static void initProvider(String packageName,int port) {
		// 包扫描
		// 创建对象
		// 注入属性
		// 发布服务
		String[] packages = packageName.split(",");
		List<Class<?>> clazzs = new ArrayList<>();

		for (String pack : packages) {
			clazzs.addAll(BasePackageUtil.scanPackage(pack));
		}
		BeanFactory.createObjects(clazzs);
		InjectPropUntils.InjectPorps(clazzs);
		
		while(true) {
			ServerPublish.publishServer(port);	
		}
		
	}
}
