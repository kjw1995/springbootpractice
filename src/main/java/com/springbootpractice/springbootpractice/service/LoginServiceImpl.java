package com.springbootpractice.springbootpractice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springbootpractice.springbootpractice.jpa.entity.Member;
import com.springbootpractice.springbootpractice.jpa.repository.MemberRepository;
import com.springbootpractice.springbootpractice.model.UserDetailModel;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDetailModel userDetailModel = new UserDetailModel();
        
        Member member = memberRepository.findById(username);

        List<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
        auth.add(new SimpleGrantedAuthority("user"));
        userDetailModel.setAuthorities(auth);

        if(member == null) {
            throw new UsernameNotFoundException("존재하지 않는 회원입니다.");
        }

    
        return userDetailModel;
    }



    
}
