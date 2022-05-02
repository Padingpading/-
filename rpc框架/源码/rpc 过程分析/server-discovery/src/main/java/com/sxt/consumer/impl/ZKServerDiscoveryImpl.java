package com.sxt.consumer.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;

import com.sxt.consumer.ServerDiscovery;


public class ZKServerDiscoveryImpl implements ServerDiscovery {

	private static Map<String,List<String>> serverCache = new HashMap<>();

	private static ZkClient client = null ;

	static {
		client = new ZkClient("192.168.231.139:2181");
	}

	@Override
	public List<String> discovery(String name) {
		if(serverCache.containsKey(name)) {
			return serverCache.get(name);
		}

		String path = "/"+name;
		if(!client.exists(path)) {
			return null;
		}
		List<String> uris = client.getChildren(path);
		serverCache.put(name, uris);

		client.subscribeChildChanges(path, new IZkChildListener() {
			
			@Override
			public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
				// 当服务列表发生改变了，触发该事件
				System.out.println("有节点改变了");
				serverCache.put(name, currentChilds);// 直接覆盖之前的值
			}
		});
		return uris;

	}

}
