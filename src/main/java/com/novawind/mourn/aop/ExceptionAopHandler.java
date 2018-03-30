package com.novawind.mourn.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Jeremy Xiong<br>
 * 2018-02-26 17:00
 */
@Component
@Aspect
public class ExceptionAopHandler {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionAopHandler.class);

    @Around("execution(* com.novawind.mourn.controller..*(..))")
    public Object afterException(ProceedingJoinPoint pjp){
        //MethodSignature ms = (MethodSignature)pjp.getSignature();
        Object[] args = pjp.getArgs();
        Object _return = null;
        try{
            if(args.length > 0){
                _return = pjp.proceed(args);
            } else {
                _return = pjp.proceed();
            }
        }catch (Throwable e) {
            logger.error(e.getMessage(), e);
        }
        return _return;
    }

}
