package com.sxt.core.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标记在类上，cup 会自动创建对象并放入容器里里面
 * @author CodeLab
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoBuilder {
	
	/**
	 * 对象的id，名称
	 * 若该name 为 null，会获取类的简单名称，并将第一个字母小写
	 * @return
	 */
  String name() default "";
}

