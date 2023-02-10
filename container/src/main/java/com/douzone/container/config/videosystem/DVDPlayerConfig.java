package com.douzone.container.config.videosystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.douzone.container.videosystem.Avengers;
import com.douzone.container.videosystem.DVDPlayer;
import com.douzone.container.videosystem.DigitalVideoDisc;

@Configuration
public class DVDPlayerConfig {

	@Bean
	public DigitalVideoDisc avengers() {
		return new Avengers();
	}
	
	// 주입하기(Injection) 1
	// Bean 생성 메소드를 직접 호출하는 방법
	// 생성자 주입
	@Bean("dvdPlayer")		//이렇게 이름을 정할 수 있음 default값은 메소드 이름임 => Test에서 가져올 때 해당 이름을 사용해야함
	public DVDPlayer dvdPlayer01() {
		return new DVDPlayer(avengers());
	}
	
	// 주입하기(Injection) 2
	// Parameter로 bean을 전달하는 방법
	// 생성자 주입
	@Bean
	public DVDPlayer dvdPlayer02(DigitalVideoDisc dvd) {
		return new DVDPlayer(dvd);
	}
	
	// 주입하기(Injection) 3
	// Parameter로 bean을 전달하는 방법
	// setter 주입
	@Bean
	public DVDPlayer dvdPlayer03(DigitalVideoDisc dvd) {
		DVDPlayer dvdPlayer = new DVDPlayer();
		dvdPlayer.setDvd(dvd);
		
		return dvdPlayer;
	}
}
