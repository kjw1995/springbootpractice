package com.springbootpractice.springbootpractice.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootpractice.springbootpractice.jpa.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer>{
}
