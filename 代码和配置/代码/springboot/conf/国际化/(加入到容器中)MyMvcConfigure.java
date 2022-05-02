package com.sx.springboot06.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author pad
 * @description ${description}
 * @date 2019/3/4
 */

@Configuration
public class MyMvcConfigure extends WebMvcConfigurerAdapter {
    //自己的国际化配置
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }
}
