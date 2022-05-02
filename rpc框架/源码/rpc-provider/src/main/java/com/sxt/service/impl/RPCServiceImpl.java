package com.sxt.service.impl;

import com.sxt.core.anno.AutoBuilder;
import com.sxt.service.RPCService;


@AutoBuilder
public class RPCServiceImpl implements RPCService{

	@Override
	public String testRpc(String test) {
		System.out.println("调用成功");
		return "ok";
	}

}
