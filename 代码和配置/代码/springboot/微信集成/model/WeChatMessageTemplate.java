package com.sxt.cloud.utils;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**微信发送信息的模板
 * @author Padingpading
 *
 */
public class WeChatMessageTemplate {
	//RestTemplate内置使用Jackson序列化对象，将驼峰命名为微信模板的格式
	
	@JsonProperty("touser")
	private String toUser;
	
	@JsonProperty("open_id")
	private String openId;
	
	@JsonProperty("template_id")
	private String templateId;
	
	private String url;

	private Map<String,Map<String,String>> data;
	
	public static  Map<String, String > initChipMap(String value,String color){
		Map<String, String> map = new HashMap<>();
		map.put("value", value);
		map.put("color", color);
		return map;
	}

	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Map<String, Map<String, String>> getData() {
		return data;
	}

	public void setData(Map<String, Map<String, String>> data) {
		this.data = data;
	}

	public WeChatMessageTemplate() {
		super();
	}

	public WeChatMessageTemplate(String toUser, String openId, String templateId, String url,
			Map<String, Map<String, String>> data) {
		super();
		this.toUser = toUser;
		this.openId = openId;
		this.templateId = templateId;
		this.url = url;
		this.data = data;
	}
	
	
	
	
	
	
	
}
