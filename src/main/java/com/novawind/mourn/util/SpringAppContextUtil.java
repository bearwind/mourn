package com.novawind.mourn.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * gain spring application context and get spring bean
 * @author Jeremy Xiong<br>
 * 2018-01-05 09:27
 */
@Component
public class SpringAppContextUtil implements ApplicationContextAware{

    private static ApplicationContext context;

    @Override
    public void setApplicationContext (ApplicationContext applicationContext) throws BeansException {
        if(context == null){
            context = applicationContext;
        }
    }

    public static ApplicationContext getContext () {
        return context;
    }

    public static <T> T getBean(Class<T> clazz){
        return context.getBean(clazz);
    }

    public static Object geBean(String name){
        return context.getBean(name);
    }

}
