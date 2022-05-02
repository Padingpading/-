package com.sxt.provider;

import java.util.List;

import com.sxt.anno.ExposeService;
import com.sxt.provider.impl.ZKServerRegisterImpl;

public class ServerRegisterLoader {

	private static ZKServerRegisterImpl register = new ZKServerRegisterImpl();
	
	public static void autoRedisters(List<Class<?>> clazzs,int port) {
		
		for (Class<?> clazz : clazzs) {
			autoRegister(clazz, port);
		}
	}
	/**
	 * 实现服务的注册
	 */
	public static void autoRegister(Class<?> clazz,int port) {
		ExposeService expose = clazz.getAnnotation(ExposeService.class);
		if(expose!=null) { // 服务注册
			String serverName = clazz.getInterfaces()[0].getName();
			// ip:port
			String uri = "localhost"+":"+port;
			register.register(serverName, uri);
		}
	}
}
