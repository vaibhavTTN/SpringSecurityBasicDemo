package com.SpringSecurity.demo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

public class MySecurityConfig  {

    @Autowired
    UserDetailServiceImpl userDetailServices;

    /*
        it is used for the inMemory save user
     */
//    @Bean
//    protected InMemoryUserDetailsManager inMemoryUserDetailsManager() {
//        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
//        UserDetails userDetails = User
//                .withUsername("vaibhav")
//                .password(passwordEncoder().encode("123"))
//                .authorities("read")
//                .build();
//        userDetailsService.createUser(userDetails);
//        return userDetailsService;
//    }


    @Bean
    public AuthenticationManager authManager(HttpSecurity http, PasswordEncoder passwordEncoder,
                                             UserDetailsService userDetailService) throws Exception
    {
        return http
                .getSharedObject(AuthenticationManagerBuilder.class)
                .build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.authorizeRequests()
                .anyRequest()
                .authenticated();
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
