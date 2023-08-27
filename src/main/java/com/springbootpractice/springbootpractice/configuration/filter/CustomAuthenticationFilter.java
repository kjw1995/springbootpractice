package com.springbootpractice.springbootpractice.configuration.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.springbootpractice.springbootpractice.configuration.provider.CustomAuthenticationProvider;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationFilter.class);

    public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.setAuthenticationManager(authenticationManager);
    }

    @Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {

        String id = request.getParameter("userId");
        String pw = request.getParameter("userPw");

        logger.info("id = " + id);
        logger.info("pw = " + pw);
        
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(id, pw);
        setDetails(request, authRequest);

		return this.getAuthenticationManager().authenticate(authRequest);
	}    
    
}
