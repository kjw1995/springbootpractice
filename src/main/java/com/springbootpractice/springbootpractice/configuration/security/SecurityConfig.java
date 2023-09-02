package com.springbootpractice.springbootpractice.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import com.springbootpractice.springbootpractice.configuration.filter.CustomAuthenticationFilter;
import com.springbootpractice.springbootpractice.configuration.handler.CustomLoginSuccessHandler;
import com.springbootpractice.springbootpractice.configuration.provider.CustomAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }

    @Bean
    public AuthenticationManager providerManager() { return new ProviderManager(customAuthenticationProvider()); }

    @Bean
    public AuthenticationProvider customAuthenticationProvider() { return new CustomAuthenticationProvider(passwordEncoder()); }

    @Bean
    public CustomLoginSuccessHandler loginSuccessHandler() { return new CustomLoginSuccessHandler(); }

    @Bean
    public CustomAuthenticationFilter customAuthenticationFilter() {

        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(providerManager());
        customAuthenticationFilter.setFilterProcessesUrl("/login/process");
        customAuthenticationFilter.setAuthenticationSuccessHandler(loginSuccessHandler());
        customAuthenticationFilter.afterPropertiesSet();

        return customAuthenticationFilter;
    }

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
                                .logoutSuccessUrl("/")
        );

        http.addFilterBefore(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
            

        return http.build();

    }

}
