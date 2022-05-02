package com.sxt.cloud.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.sxt.cloud.service.MessageService;
import com.sxt.cloud.service.ValidateService;
import com.sxt.cloud.utils.RandomUtil;
import com.sxt.cloud.utils.WeChatMessageTemplate;


@Service
public class ValidateServiceImpl  implements ValidateService{
	
	
	@Autowired
	private StringRedisTemplate redis;
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private static String USER_ADD_PREFIX="USER:ADD";
	
	@Value("${wechat.template.id}")
	private String templateId;

	@Override
	public void getValidateCode(String openId) {
		//1、生成验证码,生成随机数的工具类
		String randomCode  = RandomUtil.getRandom(4);
		//2、存入到reids中,并设置1分钟过期时间
		redis.opsForValue().set(USER_ADD_PREFIX+openId, randomCode);
		redis.expire(USER_ADD_PREFIX+openId, 1, TimeUnit.MINUTES);
		//3、将验证码发送给用户,发送重试三次
		int count = 3;
		while(count>0) {
			boolean sendMessage = messageService.sendWeChatMessage(getWechatMessageTemplage(openId,randomCode));
			if(sendMessage) {
				break;
			}
			count--;
		}
	}

	/**获取消息模板信息
	 * @param openID
	 * @return
	 */
	private WeChatMessageTemplate getWechatMessageTemplage(String openId,String code) {
		WeChatMessageTemplate template = new WeChatMessageTemplate();
		//1、用户的
		template.setToUser(openId);
		//2、微信消息的模板id
		template.setTemplateId(templateId);
		//3、发送给用户的id
		template.setOpenId(openId);
		//4构造消息内容,与模板内容相对应
		Map<String, Map<String,String>> data = new HashMap<>();
		//依次的值为，消息模板的字段，消息模板的字段值，消息字段显示的颜色
		data.put("user", WeChatMessageTemplate.initChipMap(openId, "#887788"));
		data.put("code", WeChatMessageTemplate.initChipMap(code, "#887788"));
		data.put("timeout", WeChatMessageTemplate.initChipMap("验证码一分钟有效", "#887788"));
		template.setData(data);
		return template;
	}
	@Override
	public boolean validateCode(String openID, String validateCode) {
		Assert.notNull(validateCode, "验证码不能为空");
		String code = redis.opsForValue().get(USER_ADD_PREFIX+openID);
		if(code!=null&&!validateCode.equals(code)){
			return true;
		}
		return false;
	}

}
