package com.springbootpractice.springbootpractice.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootpractice.springbootpractice.jpa.entity.LoginLog;

@Repository
public interface LoginLogRepository extends JpaRepository<LoginLog, Integer>{
    
}
