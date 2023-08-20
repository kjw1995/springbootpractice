package com.springbootpractice.springbootpractice.configuration.provider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCrypt;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider{

    public CustomAuthenticationProvider(BCrypt passwordEncoder2) {
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        
        throw new UnsupportedOperationException("Unimplemented method 'authenticate'");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        int i = 0;
        throw new UnsupportedOperationException("Unimplemented method 'supports'");
    }

    
    
}
