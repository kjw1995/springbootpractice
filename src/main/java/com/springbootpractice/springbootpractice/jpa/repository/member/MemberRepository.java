package com.springbootpractice.springbootpractice.jpa.repository.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootpractice.springbootpractice.jpa.entity.member.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer>{

    public Member findByUserId(String id);

}
