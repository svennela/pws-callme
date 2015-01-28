package com.pivotal.callme.repos;

import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.pivotal.callme.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@Profile("dev")
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class AgentRepositoryTest {

	@Test
	public void test() {
		// TODO: come back and implement some tests
		fail("Not yet implemented");
	}

}
