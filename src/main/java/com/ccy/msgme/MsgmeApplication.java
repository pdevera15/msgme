package com.ccy.msgme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class MsgmeApplication {
    
	public static void main(String[] args) {
		SpringApplication.run(MsgmeApplication.class, args);
	}

}
