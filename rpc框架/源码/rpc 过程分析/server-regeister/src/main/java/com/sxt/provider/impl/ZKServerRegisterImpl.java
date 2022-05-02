package com.sxt.provider.impl;

import org.I0Itec.zkclient.ZkClient;

import com.sxt.provider.ServerRegister;

public class ZKServerRegisterImpl implements ServerRegister {
	private static ZkClient client = null ;
	static {
		client = new ZkClient("192.168.231.139:2181");
	}
	@Override
	public void register(String serverName, String uri) {
		String path = "/"+serverName;
		if(!client.exists(path)) {
			client.createPersistent(path);//   /JAVA开发
		}
		path += "/"+ uri; // 
		client.createEphemeral(path); ///JAVA开发/ltd
	}

}
