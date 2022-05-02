package com.sxt.cloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sxt.cloud.service.MessageService;
import com.sxt.cloud.utils.RefreshTokenTask;
import com.sxt.cloud.utils.WeChatMessageTemplate;
import com.sxt.cloud.utils.WechatResult;

@Service
public class MessageServiceImpl implements MessageService {
	
	//java方式发送请求
	@Autowired
	private RestTemplate rest;
	
	@Value("${wechat.template.url}")
	private String  sendTemplageUrl;
	
	@Value("${wechat.app.id}")
	private String  appId;
	
	@Value("${wechat.app.secret}")
	private String  secret;
	

	
	
	
	@Override
	public boolean sendWeChatMessage(WeChatMessageTemplate weChatMessageTemplate) {
		String url = sendTemplageUrl.replaceAll("ACCESS_TOKEN", RefreshTokenTask.token);
		WechatResult wechatResult= rest.postForObject(url, weChatMessageTemplate, WechatResult.class);
		//返回值等于0，发送成成功
		if(wechatResult.getErrCode().equals(0)) {
			return true;
		}
		return false;
	}

}
