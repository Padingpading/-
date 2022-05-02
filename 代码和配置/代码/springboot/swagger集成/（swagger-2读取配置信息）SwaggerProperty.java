package com.sxt.cloud.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 负责读取application.xml的属性
 * 
 * @author Padingpading
 *
 */
@Configuration // 将对象创建一份放到容器里面
@ConfigurationProperties(prefix = "swagger") // 读取配置中间中前缀是swagger
public class SwaggerProperty {
	//扫描的做接口文档的包
	private String basePackage;
	//接扣文档作者的名称 ;
	private String name;
	//作者的主页 ;
	private String url;
	//作者的邮箱
	private String email;
	//接口的标题
	private String title;
	//接口的版本
	private String version;
	//服务团队，该接口由谁维护
	private String termsOfServiceUrl;
	//接口的开源协议
	private String license;
	//开源协议的地址
	private String licenseUrl;
	//接口的详细描述
	private String description;
	
	
	public String getBasePackage() {
		return basePackage;
	}
	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getTermsOfServiceUrl() {
		return termsOfServiceUrl;
	}
	public void setTermsOfServiceUrl(String termsOfServiceUrl) {
		this.termsOfServiceUrl = termsOfServiceUrl;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getLicenseUrl() {
		return licenseUrl;
	}
	public void setLicenseUrl(String licenseUrl) {
		this.licenseUrl = licenseUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
