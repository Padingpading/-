package com.example.demo.config;



import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pad
 * @description ${description}
 * @date 2019/3/23
 */

@Configuration
public class DuridDatasource {
    @ConfigurationProperties(prefix ="spring.dataSource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }

    //配置Druid的监控台
    //1、配置一个管理后台的servlet
   @Bean
    public ServletRegistrationBean statViewServlet(){
        //处理druid的所有请求
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        //配置参数
        Map<String,String> initParams = new HashMap<>();
        //登录后台时的账号和密码
        initParams.put("loginUsername","admin");
        initParams.put("loginPassword","123456");
        //默认允许访问(白名单)
        initParams.put("allow","");
        //禁止访问的ip(黑名单)
        initParams.put("deny","192.168.10.136");
        bean.setInitParameters(initParams);
        return bean;
    }

    //配置一个web监控的的filter
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String,String> initParams = new HashMap<>();
        initParams.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(initParams);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }



}
