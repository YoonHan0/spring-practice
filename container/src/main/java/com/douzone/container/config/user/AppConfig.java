package com.douzone.container.config.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.douzone.container.user.Friend;
import com.douzone.container.user.User;

@Configuration
@ComponentScan(basePackages={"com.douzone.container.user"})
public class AppConfig {
	
//	@Bean
//	public User user() {
//		return new User();
//	}
	
	@Bean
	public Friend friend() {
		return new Friend("Loopy");
	}
	
}