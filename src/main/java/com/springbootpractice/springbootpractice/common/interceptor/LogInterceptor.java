package com.springbootpractice.springbootpractice.common.interceptor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.springbootpractice.springbootpractice.jpa.entity.access.AccessLog;
import com.springbootpractice.springbootpractice.jpa.repository.access.AccessLogRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class LogInterceptor implements HandlerInterceptor {

    @Autowired
    private AccessLogRepository accessLogRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String accessTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String referer = request.getHeader("Referer");

        log.info("Ip = " + request.getRemoteAddr());
        log.info("access time = " + accessTime);
        log.info("referer = " + referer);

        if(referer == null) {

            AccessLog accessLog = AccessLog.builder()
                                           .ip(request.getRemoteAddr())
                                           .time(accessTime)
                                           .build();

            accessLogRepository.save(accessLog);
            
        }

        
        
        return true;
    }

    
}
