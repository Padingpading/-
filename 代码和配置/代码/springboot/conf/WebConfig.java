package com.sxt.cloud.conf;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig  extends WebMvcConfigurerAdapter{

	
	
	//注册一个拦截器
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new HandlerInterceptor() {
			@Override
			public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
					throws Exception {
				String token = request.getHeader("token");
				if(token==null||!token.equals("123456")) {
					PrintWriter writer = response.getWriter();
					writer.println("{'code':'403','msg':'token错误'}");
					writer.close();
					return false;
				}
				return true;
			}
			@Override
			public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
					ModelAndView modelAndView) throws Exception {
				
			}
			@Override
			public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
					throws Exception {
				
			}//拦截所有请求
		}).addPathPatterns("/**").excludePathPatterns(//排除swagger的依赖
				"/*.html",
				"/**/**.css",
				"/**/**.js",
				"/favicon.ico",
				"/swagger-resources/**",
				"/v2/api-docs/**",
				"/user/code",
				"/user/add"
				);
	}
	
	//Cors 添加跨域请求
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").
			//跨域请求方法
			allowedMethods("*").
				//
				allowedOrigins("*").
					//跨域是否允许cookie
					allowCredentials(true).
						//跨域是否允许那些头
						allowedHeaders("*").
							//请求成功后，距离下次验证的时间，一般两个小时
							maxAge(7200);
		super.addCorsMappings(registry);
		
	}
}
