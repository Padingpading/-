package com.sxt.cloud.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sxt.cloud.dto.Result;

/**以后所有的异常都会进该类
 * @author Padingpading
 *
 */
//web层的切面
@RestControllerAdvice
public class WebErrorLog {
	
	//记录日志
	private static   Logger logger = LoggerFactory.getLogger(WebErrorLog.class);
	
	//拦截所有的异常，异常后会进入该类
	//括号中为要处理的异常类型
	@ExceptionHandler(RuntimeException.class)
	public Result handlerRuntime(Exception exception) {
		//1、程序员
		logger.error(exception.getMessage());
		//2、用户
		return Result.error(500, "服务器错误");
		
	}
}
