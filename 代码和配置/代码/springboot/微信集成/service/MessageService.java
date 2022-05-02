package com.sxt.cloud.service;

import com.sxt.cloud.utils.WeChatMessageTemplate;

public interface MessageService {
	
	boolean sendWeChatMessage(WeChatMessageTemplate weChatMessageTemplate); 

}
