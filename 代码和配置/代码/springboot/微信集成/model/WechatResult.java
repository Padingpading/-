package com.sxt.cloud.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

/**发送模板消息后的返回值
 * @author Padingpading
 *
 */
public class WechatResult {
	
	@JsonProperty("errcode")
	private Integer errCode;
	
	@JsonProperty("errmsg")
	private String errMsg;
	
	@JsonProperty("msgid")
	private Long msgId;
	
	public Integer getErrCode() {
		return errCode;
	}
	public void setErrCode(Integer errCode) {
		this.errCode = errCode;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public Long getMsgId() {
		return msgId;
	}
	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}
	
	
	

}
