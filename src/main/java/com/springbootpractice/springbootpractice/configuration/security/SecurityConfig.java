package com.springbootpractice.springbootpractice.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, HandlerMappingIntrospector HandlerMappingIntrospector) throws Exception {
        
        /*
         * csrf 비활성화
         */
        http.csrf((csrf) -> csrf.disable());

    
        /*
         * 커스텀 로그인 방식
         */
        http.formLogin((formLogin) -> formLogin
                                    .usernameParameter("userId")                                    
                                    .passwordParameter("userPw")
                                    .loginPage("/login.html")
                                    .failureUrl("/login/fail")
                                    .loginProcessingUrl("/login/process")
        );

        /*
         * 로그아웃 설정
         */
        http.logout((logout) -> logout
                                .deleteCookies("remove")
                                .invalidateHttpSession(true)
                                .logoutUrl("/logout")
                                .logoutSuccessUrl("/main")
        );
            

        return http.build();

    }

}
