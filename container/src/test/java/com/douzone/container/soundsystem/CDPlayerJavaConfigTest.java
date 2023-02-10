package com.douzone.container.soundsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.douzone.container.config.soundsystem.CDPlayerConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes={CDPlayerConfig.class})
public class CDPlayerJavaConfigTest {
	@Autowired
	private CDPlayer cdPlayer;
	
	@Test
	public void testCDPlayerNotNull() {
		assertNotNull(cdPlayer);
	}
	
	@Test
	public void testPlay() {
		assertEquals("Playing 붕붕 by 김하온", cdPlayer.play());
	}
}