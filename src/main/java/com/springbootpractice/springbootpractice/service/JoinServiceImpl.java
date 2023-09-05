package com.springbootpractice.springbootpractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springbootpractice.springbootpractice.jpa.entity.Member;
import com.springbootpractice.springbootpractice.jpa.repository.MemberRepository;
import com.springbootpractice.springbootpractice.model.JoinProcessModel;

@Service
public class JoinServiceImpl implements JoinService{

    @Autowired
    private MemberRepository memberRepository;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void joinProcess(JoinProcessModel joinProcessModel) {
        
        Member joinMember = Member.builder()
                                  .id(joinProcessModel.getJoinId())
                                  .pw(passwordEncoder.encode(joinProcessModel.getJoinPassword()))
                                  .email(joinProcessModel.getEmail())
                                  .phoneNumber(joinProcessModel.getPhoneNumber())
                                  .build();

        memberRepository.save(joinMember);

    }
    
}
