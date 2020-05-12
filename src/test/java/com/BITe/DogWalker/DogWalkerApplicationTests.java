package com.BITe.DogWalker;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.BITe.DogWalker.web.WalksController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DogWalkerApplication.class)
class DogWalkerApplicationTests {
	@Autowired
	private WalksController controller;
	
	@Test
	void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
