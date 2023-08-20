package com.springbootpractice.springbootpractice.configuration.filter;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.setAuthenticationManager(authenticationManager);
    }

    @Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {

        String id = request.getParameter("userId");
        String pw = request.getParameter("userPw");
        
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(id, pw);
        setDetails(request, authRequest);

		return this.getAuthenticationManager().authenticate(authRequest);
	}    
    
}
