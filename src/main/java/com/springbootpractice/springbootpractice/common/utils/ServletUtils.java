package com.springbootpractice.springbootpractice.common.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class ServletUtils {

    /*
     * Request 가져오기
     */
    public static HttpServletRequest getRequest() {

        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        if(servletRequestAttributes == null) {
            return null;
        }

        return servletRequestAttributes.getRequest();

    }

    /*
     * 세션 가져오기
     */
    public static HttpSession getSession() {
        return getRequest().getSession();
    }

}
