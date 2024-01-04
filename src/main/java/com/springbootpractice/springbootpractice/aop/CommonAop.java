package com.springbootpractice.springbootpractice.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.springbootpractice.springbootpractice.common.url.commonUrl;

@Aspect
@Component
@Order(1)
public class CommonAop {
    
    @Pointcut("execution(public * com.springbootpractice.springbootpractice.controller..*(..))")
    private void commonCut() {}

    @Pointcut("within(com.springbootpractice.springbootpractice.controller..*)") // 3
    public void onRequest() {}

    @AfterReturning(pointcut = "commonCut()", returning = "modelAndView")
    public void returnViewModel(ModelAndView modelAndView) {

        modelAndView.addObject("commonUrls", new commonUrl());

    }


}
