package com.novawind.mourn.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Jeremy Xiong<br>
 * 2017-12-22 17:51
 */
@Configuration
public class InterceptorRegister extends WebMvcConfigurerAdapter{

    @Override
    public void addInterceptors (InterceptorRegistry registry) {
        registry.addInterceptor(new RequestInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/access/*","/css/**");
    }
}
