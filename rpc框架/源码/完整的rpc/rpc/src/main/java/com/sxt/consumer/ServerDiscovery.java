package com.sxt.consumer;

import java.util.List;

public interface ServerDiscovery {
  
	/**
	 * 服务的发现
	 * @param name
	 * @return
	 */
	List<String> discovery(String name);
}
