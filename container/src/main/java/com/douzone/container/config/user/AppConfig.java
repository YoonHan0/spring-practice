package com.douzone.container.config.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.douzone.container.user.Friend;

@Configuration
@ComponentScan(basePackages={"com.douzone.container.user"})
public class AppConfig {
	
	@Bean
	public Friend firend() {
		return new Friend("Loopy");
	}
}