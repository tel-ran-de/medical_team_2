package com.example.health_checker.aspect;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;


@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Pointcut("execution(public * com.example.health_checker.controller.*.*(..))")
    public void controllerLog() {
    }

    @Pointcut("execution(public * com.example.health_checker.service.*.*(..))")
    public void serviceLog() {
    }

    @Before("controllerLog()")
    public void doBeforeController(JoinPoint jp) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("NEW REQUEST:\n" +
                        "IP : {}\n" +
                        "URL : {}\n" +
                        "HTTP_METHOD : {}\n" +
                        "CONTROLLER_METHOD : {}.{}",
                request.getRemoteAddr(),
                request.getRequestURL().toString(),
                request.getMethod(),
                jp.getSignature().getDeclaringTypeName(), jp.getSignature().getName());
    }

    @Before("serviceLog()")
    public void doBeforeService(JoinPoint jp) {
        log.info("RUN SERVICE:\n" +
                        "SERVICE_METHOD : {}.{}",
                jp.getSignature().getDeclaringTypeName(), jp.getSignature().getName());
    }

    @AfterReturning(returning = "returnObject", pointcut = "controllerLog()")
    public void doAfterReturning(Object returnObject) {
        log.info("\nReturn value: {}\n" +
                        "END OF REQUEST",
                returnObject);
    }

    @AfterThrowing(throwing = "ex", pointcut = "controllerLog()")
    public void throwsException(JoinPoint jp, Exception ex) {
        log.error("Request throw an exception. Cause - {}. {}",
                Arrays.toString(jp.getArgs()), ex.getMessage());
    }
}