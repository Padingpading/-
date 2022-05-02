package com.sxt.core.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标记在属性上面，用来给对象注入属性
 * @author CodeLab
 * 该注解默认以类型注入，若id 不为null，优先使用id 注入
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Inject {
   
	String id() default "";
}
