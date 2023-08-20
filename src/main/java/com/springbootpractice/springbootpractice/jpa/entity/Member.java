package com.springbootpractice.springbootpractice.jpa.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name="Member")
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idx")
    private Integer idx;

    @Column(name="id")
    private String id;

    @Column(name="pw")
    private String pw;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="email")
    private String email;

}
