package com.springbootpractice.springbootpractice.dto.session;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SessionDto implements Serializable{

    /*
     * 회원 아이디
     */
    private String userId;

    /*
     * 회원 전화번호
     */
    private String phoneNumber;

    /*
     * 회원 이메일
     */
    private String email;

}
