package com.springbootpractice.springbootpractice.configuration.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.springbootpractice.springbootpractice.model.UserDetailModel;
import com.springbootpractice.springbootpractice.service.LoginService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

    public CustomAuthenticationProvider(BCryptPasswordEncoder passwordEncoder) {}

    @Autowired
    private LoginService loginService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        
        String userName = authentication.getName();
        String userPassword = authentication.getCredentials().toString();

        UserDetailModel userDetailModel = (UserDetailModel)loginService.loadUserByUsername(userName);

        if(!passwordEncoder.matches(userPassword, userDetailModel.getPassword())) {
            throw new BadCredentialsException("비밀번호가 불일치 합니다.");
        }

        return new UsernamePasswordAuthenticationToken(
                                                        userDetailModel, 
                                                        null, 
                                                        userDetailModel.getAuthorities()
                                                      );
    }

    @Override
    public boolean supports(Class<?> authentication) { return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication); }

}
