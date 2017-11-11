/*
package com.shenghe.logging;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;

@Aspect
@Component
@Order(-5)
public class AopControllerLogging {

    private Logger logger =  LoggerFactory.getLogger(this.getClass());

//    @Pointcut("execution(*Controller*.*(..))")
    //所有*Controller*的类都会被切入
    @Pointcut("execution(public * com.shenghe*..*Controller.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint){
        // 接收到请求，记录请求内容
//        logger.info(" WebLogAspect.doBefore()");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        StringBuilder sessionId = new StringBuilder(request.getSession().getId());
        logger.info(sessionId.append(" request url=").append(request.getRequestURI())
                .append(" params=").append(JSON.toJSONString(request.getParameterMap()))
                .append(" ip").append(request.getRemoteAddr()).toString());
        // 记录下请求内容
//        logger.info("URL : " + request.getRequestURL().toString());
//        logger.info("HTTP_METHOD : " + request.getMethod());
//        logger.info("IP : " + request.getRemoteAddr());
//        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
//        //获取所有参数方法一：
//        Enumeration<String> enu=request.getParameterNames();
//        while(enu.hasMoreElements()){
//            String paraName=(String)enu.nextElement();
//            System.out.println(paraName+": "+request.getParameter(paraName));
//        }
    }

    @After("webLog()")
    public void  doAfter(JoinPoint joinPoint){
        // 处理完请求，返回内容
        MethodInvocationProceedingJoinPoint methodInvocationProceedingJoinPoint = (MethodInvocationProceedingJoinPoint) joinPoint;
//        logger.info("WebLogAspect.doAfterReturning()");
    }

    @AfterReturning("webLog()")
    @AfterThrowing("webLog()")
    public void  doAfterReturning(JoinPoint joinPoint){
        // 处理完请求，返回内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        MethodInvocationProceedingJoinPoint methodInvocationProceedingJoinPoint = (MethodInvocationProceedingJoinPoint) joinPoint;
        StringBuilder sessionId = new StringBuilder(request.getSession().getId());
//        logger.info("WebLogAspect.doAfterReturning()");
        try {
            logger.info(sessionId.append(" response ").append(JSON.toJSONString(methodInvocationProceedingJoinPoint.proceed())).toString());
        } catch (Throwable throwable) {
            logger.error(sessionId.append(" response 解析错误").toString(),throwable);
        }
    }
}
*/
