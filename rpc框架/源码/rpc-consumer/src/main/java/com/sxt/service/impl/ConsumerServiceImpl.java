package com.sxt.service.impl;

import com.sxt.anno.InjectProxy;
import com.sxt.core.anno.AutoBuilder;
import com.sxt.service.ConsumerService;
import com.sxt.service.RPCService;

@AutoBuilder
public class ConsumerServiceImpl implements ConsumerService{

	@InjectProxy
	private RPCService rpc;

	@Override
	public String consumer(String test) {
		String testRpc = rpc.testRpc("你好");
		System.out.println("远程调用成功，值为"+testRpc);
		return "我已经成功的完成了远程调用";
	}
	
	
	
}
