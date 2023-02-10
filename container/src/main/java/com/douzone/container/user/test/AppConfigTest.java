package com.douzone.container.user.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.douzone.container.config.user.AppConfig;
import com.douzone.container.user.Friend;
import com.douzone.container.user.User;

public class AppConfigTest {

	public static void main(String[] args) {
		testAppConfig();
	}

	private static void testAppConfig() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		
		User user = ac.getBean(User.class);
		System.out.println(user);
		
		Friend friend = ac.getBean(Friend.class);
		System.out.println(friend);
	}

}