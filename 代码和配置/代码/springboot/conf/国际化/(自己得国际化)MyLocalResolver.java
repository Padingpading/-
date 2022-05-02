package com.sx.springboot06.conf;


import org.springframework.boot.autoconfigure.web.WebMvcProperties;
import org.springframework.cglib.core.Local;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author pad
 * @description ${description}
 * @date 2019/3/4
 */
public class MyLocalResolver  implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String acceptLanguage = request.getParameter("acceptLanguage");
        //如果不存在，则使用默认的语言
        Locale locale = Locale.getDefault();
        if(!StringUtils.isEmpty(acceptLanguage)){
            //分成语言代码和国家代码
            String[] split = acceptLanguage.split("_");
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }
    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
