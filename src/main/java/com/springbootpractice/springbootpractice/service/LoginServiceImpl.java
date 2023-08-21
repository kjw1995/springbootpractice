package com.springbootpractice.springbootpractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springbootpractice.springbootpractice.jpa.entity.Member;
import com.springbootpractice.springbootpractice.jpa.repository.MemberRepository;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        

        Member member = memberRepository.findById(username);

        if(member == null) {
            throw new BadCredentialsException(username, null);
        }

    
        return null;
    }



    
}
