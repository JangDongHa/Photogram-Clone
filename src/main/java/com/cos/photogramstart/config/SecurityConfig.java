package com.cos.photogramstart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // 해당 파일로 시큐리티 활성화
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.
                csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/user/**", "/image/**", "/subscribe/**", "/comment/**")
                .authenticated()
                .anyRequest()
                .permitAll()
                .and()
                .formLogin()
                .loginPage("/auth/signin")
                .defaultSuccessUrl("/");
        return http.build();
    }
}
