package com.sxt.cloud.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**获取微信的token,注意在启动的类中添加注解，@enableScheduling，开启定时任务
 * @author Padingpading
 *
 */
@Component
public class RefreshTokenTask {
	
	public static String token="";
	
	@Value("${wechat.token.url}")
	private String tokenUrl;
	
	@Value("${wechat.app.id}")
	private String appId;
	
	@Value("${wechat.app.secret}")
	private String secret;
	
	@Autowired
	private RestTemplate rest;
	
	//初始化时间:spring启动后的10毫秒
	//定时获取token:时间为2个小时 
	@Scheduled(initialDelay=10,fixedDelay=7200*1000)
	public void getRefreshToken() {
		//替换链接中的微信账号和密码
		String url =  tokenUrl.replaceAll("APPID", appId).replaceAll("APPSECRET", secret);
		AccessToken accessToken = rest.getForObject(url, AccessToken.class);
		token = accessToken.getAccessToken();
		System.out.println("token已经刷新,本次的token为"+token);
	}

}
