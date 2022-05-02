package com.sxt.test.service.impl;

import com.sxt.core.anno.AutoBuilder;
import com.sxt.core.anno.Inject;
import com.sxt.test.dao.TestDao;
import com.sxt.test.service.TestService;

@AutoBuilder(name="testServiceImpl")
public class TestServiceImpl implements TestService {

	@Inject
	private TestDao dao;
	
	@Override
	public String test(String test) {
		Integer test2 = dao.test();
		System.out.println("调用成功"+test2);
		return "hello,cup,"+test+":"+test2;
	}
 
	
}
