package com.novawind.mourn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Jeremy Xiong<br>
 * 2017-12-22 17:51
 */
@Configuration
public class InterceptorRegister extends WebMvcConfigurerAdapter{

    //注入拦截器bean，否则spring在bean加载之前已初始化拦截器，在拦截器内依赖注入其他类会为null
    @Bean
    public RequestInterceptor requestInterceptor(){
        return new RequestInterceptor();
    }

    @Override
    public void addInterceptors (InterceptorRegistry registry) {
        registry.addInterceptor(requestInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/access/*","/error", "/css/**");
    }
}
