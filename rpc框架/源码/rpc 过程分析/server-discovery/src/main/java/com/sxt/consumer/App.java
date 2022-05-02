package com.sxt.consumer;

import java.util.List;

import com.sxt.consumer.impl.RandomLoadBalance;
import com.sxt.consumer.impl.ZKServerDiscoveryImpl;

public class App {
  public static void main(String[] args) throws InterruptedException {
	ZKServerDiscoveryImpl zkServerDiscoveryImpl = new ZKServerDiscoveryImpl();
	while(true) {
		List<String> uris = zkServerDiscoveryImpl.discovery("JAVA");
		System.out.println(uris);
		Thread.sleep(5000);
	}
  }
}
