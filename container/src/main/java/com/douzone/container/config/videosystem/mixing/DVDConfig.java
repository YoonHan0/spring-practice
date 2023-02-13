package com.douzone.container.config.videosystem.mixing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.douzone.container.videosystem.Avengers;
import com.douzone.container.videosystem.BlankDisc;
import com.douzone.container.videosystem.DigitalVideoDisc;

@Configuration
public class DVDConfig {

	@Bean
	public DigitalVideoDisc avenger() {
		return new Avengers();
	}
	
	@Bean
	public DigitalVideoDisc avengersInfinityWar() {
		BlankDisc dvd = new BlankDisc();
		dvd.setTitle("Avengers Infinity War");
		dvd.setStudio("MARVEL");
		
		return dvd;
	}
	
}