package com.springbootpractice.springbootpractice.configuration.handler;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.springbootpractice.springbootpractice.common.utils.SessionUtil;
import com.springbootpractice.springbootpractice.common.utils.StringFormatUtil;
import com.springbootpractice.springbootpractice.dto.session.SessionDto;
import com.springbootpractice.springbootpractice.jpa.entity.login.LoginLog;
import com.springbootpractice.springbootpractice.jpa.entity.member.Member;
import com.springbootpractice.springbootpractice.jpa.repository.login.LoginLogRepository;
import com.springbootpractice.springbootpractice.jpa.repository.member.MemberRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

    @Autowired
    private SessionUtil sessionUtils;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private LoginLogRepository loginLogRepository;

    @Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {

        String userId = (String)authentication.getPrincipal();
        
        Member member = memberRepository.findById(userId);

        LoginLog loginLog = LoginLog.builder()
                                    .loginId(userId)
                                    .accessIp(request.getRemoteAddr())
                                    .accessTime(StringFormatUtil.LocalDateTimeNowToString(StringFormatUtil.SIMPLE_FORMAT_YEARTOSECONDS))
                                    .build();

        loginLogRepository.save(loginLog);

        SessionDto sessionDto = SessionDto.builder()
                                          .userId(member.getId())
                                          .phoneNumber(member.getPhoneNumber())
                                          .email(member.getEmail())
                                          .build();

        sessionUtils.setSession(sessionDto);

	}
    
}
