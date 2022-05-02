package com.sxt.provider;

/**
 * 服务的注册
 * @author CodeLab
 *
 */
public interface ServerRegister {
	/**
	 * 服务注册，将服务放在注册中心里面，让别人能查到。
	 * @param serverName
	 * 服务的名称
	 * @param uri
	 * 服务的地址
	 */
	void register(String serverName,String uri);
}
