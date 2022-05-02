package com.sxt.cloud.utils;


import com.fasterxml.jackson.annotation.JsonProperty;

/**获取token返回做的封装对象
 * @author Padingpading
 *
 */
public class AccessTokenResult {
	
	@JsonProperty("access_token")
	private String accessToken;
	
	
	@JsonProperty("expires_in")
	private Long expiresIn;


	public String getAccessToken() {
		return accessToken;
	}


	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}


	public Long getExpiresIn() {
		return expiresIn;
	}


	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}


	
}
