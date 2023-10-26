package com.genspark.clientmanagement.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurity {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.DELETE).authenticated()
                .requestMatchers(HttpMethod.GET,"/clients/*").authenticated()
                .anyRequest().permitAll()
                .and().oauth2Login()
                .and().httpBasic()
                .and().csrf().disable();

        return httpSecurity.build();
    }
}
