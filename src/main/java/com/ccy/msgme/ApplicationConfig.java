package com.ccy.msgme;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ApplicationConfig {
    
    private final Logger logger = LoggerFactory.getLogger(ApplicationConfig.class);
    
    @Bean
    public PasswordEncoder encoder() {
        logger.info("PasswordEncoder Instantiated");
        return new BCryptPasswordEncoder();
    }
    
}
