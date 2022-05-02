package com.sxt.test.context;

import com.sxt.core.context.BeanCup;
import com.sxt.core.label.Label;
import com.sxt.test.dao.TestDao;
import com.sxt.test.dao.impl.TestDaoImpl;
import com.sxt.test.service.TestService;
import com.sxt.test.service.impl.TestServiceImpl;

public class App {
	public static void main(String[] args) {
		TestServiceImpl testServiceImpl = new TestServiceImpl();

		Label label = new Label();
		label.setId("testServiceImpl");
		label.setInterfaces(testServiceImpl.getClass().getInterfaces()[0]);
		BeanCup.putObject(label, testServiceImpl);

		TestDaoImpl testDaoImpl = new TestDaoImpl();
		Label label1 = new Label();
		label1.setId("testDaoImpl");
		label1.setInterfaces(testDaoImpl.getClass().getInterfaces()[0]);
		BeanCup.putObject(label1, testDaoImpl);

		/**
		 * 假设能取出来
		 */
		Object object1  = BeanCup.getObject("testServiceImpl");
		System.out.println(object1);
		Object object2 = BeanCup.getObject(TestService.class);
		System.out.println(object2);

		Object object3 = BeanCup.getObject("testDaoImpl");
		System.out.println(object3);
		Object object4 = BeanCup.getObject(TestDao.class);
		System.out.println(object4);
	}
}
