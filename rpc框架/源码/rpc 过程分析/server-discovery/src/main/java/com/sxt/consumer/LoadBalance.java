package com.sxt.consumer;

import java.util.List;

/**
 * 负载均衡的
 * @author CodeLab
 *
 */
public interface LoadBalance {
 
	String loadBalance(List<String> uris);
}
