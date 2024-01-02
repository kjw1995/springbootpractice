package com.springbootpractice.springbootpractice.service.join;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springbootpractice.springbootpractice.jpa.entity.member.Member;
import com.springbootpractice.springbootpractice.jpa.repository.member.MemberRepository;
import com.springbootpractice.springbootpractice.model.join.JoinProcessModel;
import com.springbootpractice.springbootpractice.model.response.ResponseModel;

@Service
public class JoinServiceImpl implements JoinService{

    @Autowired
    private MemberRepository memberRepository;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public ResponseModel joinProcess(JoinProcessModel joinProcessModel) {
        
        Member joinMember = Member.builder()
                                  .userId(joinProcessModel.getJoinId())
                                  .pw(passwordEncoder.encode(joinProcessModel.getJoinPassword()))
                                  .email(joinProcessModel.getJoinEmail())
                                  .phoneNumber(joinProcessModel.getJoinPhoneNumber())
                                  .build();

        memberRepository.save(joinMember);

        return new ResponseModel(ResponseModel.ResponseStatus.SUCCESS, "회원 가입이 완료되었습니다.");

    }

    @Override
    public ResponseModel checkId(String id) {

        Member queryObject = memberRepository.findByUserId(id);

        if(queryObject == null) {
            return new ResponseModel(ResponseModel.ResponseStatus.SUCCESS, "사용 가능한 아이디입니다.");
        } 

        return new ResponseModel(ResponseModel.ResponseStatus.FAILED, "이미 사용중인 아이디입니다.");
        
    }
    
}
