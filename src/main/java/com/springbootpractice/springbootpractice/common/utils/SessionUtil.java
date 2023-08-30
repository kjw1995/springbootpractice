package com.springbootpractice.springbootpractice.common.utils;

import org.springframework.stereotype.Component;

import com.springbootpractice.springbootpractice.dto.session.SessionDto;

@Component
public class SessionUtil {
    
    private static final String BASIC_USER_SESSION_KEY = "BASIC_USER";

    /*
     * 세션 설정
     */
    public void setSession(SessionDto sessionDto) {
        setAttribute(BASIC_USER_SESSION_KEY, sessionDto);
    }

    /*
     * 현재 세션 가져오기
     */
    public SessionDto getSession() {
        return (SessionDto)getAttribute();
    }

    private void setAttribute(String key, Object value) {

        ServletUtils.getSession().setAttribute(key, value);

    }  

    private Object getAttribute() {

        return ServletUtils.getSession().getAttribute(BASIC_USER_SESSION_KEY);

    }


}
