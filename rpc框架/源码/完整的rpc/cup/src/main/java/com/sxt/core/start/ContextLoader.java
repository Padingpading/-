package com.sxt.core.start;

import java.util.ArrayList;
import java.util.List;

import com.sxt.core.context.BeanCup;
import com.sxt.core.utils.BasePackageUtil;
import com.sxt.core.utils.BeanFactory;
import com.sxt.core.utils.InjectPropUntils;
import com.sxt.test.service.TestService;

public class ContextLoader {


	public static void main(String[] args) {

		initd("com.sxt.test.dao.impl,com.sxt.test.service.impl");
		TestService testService = (TestService)BeanCup.getObject(TestService.class);
		String test = testService.test("heihei");
		System.out.println(test);
		 
	}

	public static void initd(String packageName) {
		// 1 包扫描
		// 2 创建对象
		// 3注入属性
		String[] packages = packageName.split(",");
		List<Class<?>> clazzs = new ArrayList<>();
		
		for (String pack : packages) {
			clazzs.addAll(BasePackageUtil.scanPackage(pack));
		}
		
		BeanFactory.createObjects(clazzs);
		InjectPropUntils.InjectPorps(clazzs);
	}
}
