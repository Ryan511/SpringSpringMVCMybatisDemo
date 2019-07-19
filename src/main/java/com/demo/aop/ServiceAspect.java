package com.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


/**
 * Description:
 *
 * @author: zhongziqi
 * @Date: 2019-07-17
 * @Time: 16:16
 */
@Service
//@Aspect
public class ServiceAspect {
    private static Logger logger = LoggerFactory.getLogger(ServiceAspect.class);

    //配置切入点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点
//    @Pointcut("execution(* com.demo.service.UserService.getUsers(..))")
//    public void aspect() {
//    }

    /*
     * 配置前置通知,使用在方法aspect()上注册的切入点
     * 同时接受JoinPoint切入点对象,可以没有该参数
     */
//    @Before("aspect()")
    public void before() {
        logger.info("before = ");
//        throw new RuntimeException("test");
    }

    //配置后置通知,使用在方法aspect()上注册的切入点
//    @After("aspect()")
    public void after() {
        logger.info("after = ");
    }

    //配置环绕通知,使用在方法aspect()上注册的切入点
//    @Around("aspect()")
    public void around(JoinPoint joinPoint) {
        logger.info("around start = " + joinPoint);
        long start = System.currentTimeMillis();
        try {
            ((ProceedingJoinPoint) joinPoint).proceed();
            long end = System.currentTimeMillis();
            logger.info("around  end = " + joinPoint + "\tUse time : " + (end - start));
        } catch (Throwable e) {
            long end = System.currentTimeMillis();
            logger.info("around " + joinPoint + "\tUse time : " + (end - start) + " ms with exception : " + e.getMessage());
        }
    }

    //配置后置返回通知,使用在方法aspect()上注册的切入点
//    @AfterReturning("aspect()")
    public void afterReturn() {
        logger.info("afterReturn = ");
    }

    //配置抛出异常后通知,使用在方法aspect()上注册的切入点
//    @AfterThrowing(pointcut = "aspect()", throwing = "ex")
    public void afterThrow() {
        logger.info("AfterThrowing = ");
    }
}
