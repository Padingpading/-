package com.sx.gmall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.MethodConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.sx.gmall.service.UserService;

@Configuration
public class MyDubboConfig {

	@Bean
	public ApplicationConfig applicationConfig() {
		ApplicationConfig applicationConfig = new ApplicationConfig();
		applicationConfig.setName("appName");
		return applicationConfig;
	}
	@Bean
	public RegistryConfig registryConfig() {
		RegistryConfig config = new RegistryConfig();
		config.setAddress("192.168.10.136:1281");
		config.setProtocol("zookeeper");
		return config;
	}
	@Bean
	public  ProtocolConfig protocolConfig() {
		ProtocolConfig config = new ProtocolConfig();
		config.setName("dubbo");
		config.setPort(20882);
		return config;
	}
	@Bean
	public ServiceConfig<UserService> userServiceConfig(UserService service){
		ServiceConfig<UserService> config = new ServiceConfig<>();
		config.setInterface(UserService.class);
		config.setRef(service);
		//设置版本信息
		config.setVersion("1.0.0");
		//设置方法的信息
		MethodConfig methodConfig =new MethodConfig();
		//设置方法的名字
		methodConfig.setName("");
		//设置超时的属性。
		methodConfig.setTimeout(1000);
		//将method的是设置保存到service配置中。
		List<MethodConfig> methodConfigList = new ArrayList<>();
		methodConfigList.add(methodConfig);
		config.setMethods(methodConfigList);
		return config;
	}
}
