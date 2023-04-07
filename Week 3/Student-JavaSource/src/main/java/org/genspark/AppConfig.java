package org.genspark;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "org.genspark")
public class AppConfig {

    @Bean
    public Student getStudent() {
        return new Student();
    }

    @Bean
    public Phone getPhone() {
        return new Phone();
    }

    @Bean
    public Address getAddress() {
        return new Address();
    }
}
