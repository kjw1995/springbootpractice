package com.springbootpractice.springbootpractice.configuration.handler;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.springbootpractice.springbootpractice.common.utils.SessionUtil;
import com.springbootpractice.springbootpractice.dto.session.SessionDto;
import com.springbootpractice.springbootpractice.jpa.entity.Member;
import com.springbootpractice.springbootpractice.jpa.repository.MemberRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

    @Autowired
    private SessionUtil sessionUtils;

    @Autowired
    private MemberRepository memberRepository;

    @Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        
        Member member = memberRepository.findById((String)authentication.getPrincipal());

        SessionDto sessionDto = SessionDto.builder()
                                          .userId(member.getId())
                                          .phoneNumber(member.getPhoneNumber())
                                          .email(member.getEmail())
                                          .build();

        sessionUtils.setSession(sessionDto);

	}
    
}
