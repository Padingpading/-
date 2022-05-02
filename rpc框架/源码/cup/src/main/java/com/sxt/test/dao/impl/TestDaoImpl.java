package com.sxt.test.dao.impl;

import com.sxt.core.anno.AutoBuilder;
import com.sxt.test.dao.TestDao;

@AutoBuilder
public class TestDaoImpl implements TestDao {

	@Override
	public Integer test() {
		return 0;
	}

}
