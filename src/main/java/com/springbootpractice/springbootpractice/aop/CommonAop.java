package com.springbootpractice.springbootpractice.aop;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.MapBindingResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.springbootpractice.springbootpractice.common.url.commonUrl;
import com.springbootpractice.springbootpractice.common.utils.MapUtils;

import jakarta.servlet.http.HttpServletRequest;

@Aspect
@Component
@Order(1)
public class CommonAop {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    // @Autowired
	// private Validator validator;
    
    @Pointcut("execution(public * com.springbootpractice.springbootpractice.controller..*(..))")
    private void commonCut() {}

    @Pointcut("within(com.springbootpractice.springbootpractice.controller..*)")
    public void onRequest() {}

    @Around("com.springbootpractice.springbootpractice" + ".aop.CommonAop.onRequest()")
	public Object doLogging(ProceedingJoinPoint pjp) throws Throwable {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

		Map<String, String[]> paramMap = request.getParameterMap();
		String params = "";
		if (paramMap.isEmpty() == false) {
			params = " [" + MapUtils.paramMapToString(paramMap) + "]";
		}

		long start = System.currentTimeMillis();
		try {
			return pjp.proceed(pjp.getArgs()); // 6
		} finally {
			long end = System.currentTimeMillis();
			logger.info("Request: {} {}{} < {} ({}ms)", request.getMethod(), request.getRequestURI(),
					params, request.getRemoteHost(), end - start);
		}
	}

	// @Pointcut("within(com.hellofintech.hellofunding.api..*) || within(com.hellofintech.hellofunding.service..*) && @args(javax.validation.Valid)")
	// public void validationPointcut(){ }

	// @Before("validationPointcut() && args(param)")
	// public void validate(Object param) throws BindException {
	// 	logger.info("validation Aop Execute");
	// 	//validation
	// 	Set<ConstraintViolation<Object>> violationSet = validator.validate(param);

	// 	if(violationSet == null || violationSet.size() == 0) return;

	// 	String objectName = param.getClass().getSimpleName();
	// 	BindingResult bindingResult = new MapBindingResult(new HashMap<>(), objectName);

	// 	for (ConstraintViolation<Object> constraintViolation : violationSet) {
	// 		bindingResult.addError(new FieldError(objectName, constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage()));
	// 		logger.debug("objectName [" + objectName + "] FieldName [" + constraintViolation.getPropertyPath().toString() + "] ErrorMessage[" + constraintViolation.getMessage() + "]");
	// 	}

	// 	throw new BindException(bindingResult);

	// }

    @AfterReturning(pointcut = "commonCut()", returning = "modelAndView")
    public void returnViewModel(ModelAndView modelAndView) {

        modelAndView.addObject("commonUrls", new commonUrl());

    }


}
