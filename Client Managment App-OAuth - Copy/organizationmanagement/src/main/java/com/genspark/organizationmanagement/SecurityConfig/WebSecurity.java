package com.genspark.organizationmanagement.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurity {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity.authorizeHttpRequests()
                .requestMatchers("/orgs/*").permitAll()
                .anyRequest().authenticated()
                .and().oauth2Login();

        return httpSecurity.build();
    }
}
