package com.springbootpractice.springbootpractice.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootpractice.springbootpractice.jpa.entity.AccessLog;

@Repository
public interface AccessLogRepository extends JpaRepository<AccessLog, Integer> {
    
}
