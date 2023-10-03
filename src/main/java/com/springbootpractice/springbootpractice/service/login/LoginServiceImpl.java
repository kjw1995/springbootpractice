package com.springbootpractice.springbootpractice.service.login;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springbootpractice.springbootpractice.jpa.entity.member.Member;
import com.springbootpractice.springbootpractice.jpa.repository.member.MemberRepository;
import com.springbootpractice.springbootpractice.model.security.UserDetailModel;

@Service
public class LoginServiceImpl implements LoginService{

    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private MemberRepository memberRepository;

    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDetailModel userDetailModel = new UserDetailModel();
        
        Member member = memberRepository.findByUserId(username);

        if(member == null) {
            logger.info("존재하지 않는 회원입니다.");
            throw new UsernameNotFoundException("존재하지 않는 회원입니다.");
        }

        logger.info("memberPw = " + member.getPw());

        userDetailModel.setPassword(member.getPw());

        List<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
        auth.add(new SimpleGrantedAuthority("user"));

        userDetailModel.setAccountNonExpired(false);
        userDetailModel.setAccountNonLocked(false);
        userDetailModel.setCredentialsNonExpired(false);
        userDetailModel.setEnabled(false);
        userDetailModel.setAuthorities(auth);

        return userDetailModel;
    }

    
    


    
}
