package com.springbootpractice.springbootpractice.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootpractice.springbootpractice.jpa.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer>{

    public Member findById(String id);

}
