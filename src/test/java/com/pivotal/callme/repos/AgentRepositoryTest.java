package com.pivotal.callme.repos;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pivotal.callme.config.LocalDataSourceConfig;
import com.pivotal.callme.domain.Agent;
import com.pivotal.callme.domain.AgentStatusType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		classes={RepoTestConfig.class, LocalDataSourceConfig.class}, 
		initializers=ConfigFileApplicationContextInitializer.class)
public class AgentRepositoryTest {

	@Autowired
	AgentRepository agentRepo;

	@Before
	public void setUp() {
		agentRepo.saveAndFlush(new Agent(null, "Albert Belle", "216-545-2300", "abelle", AgentStatusType.OFFLINE));
		agentRepo.saveAndFlush(new Agent(null, "Frank Williams", "747-232-9789", "frankwilliams", AgentStatusType.ONLINE));
		agentRepo.saveAndFlush(new Agent(null, "Gary Collins", "545-877-1212", "fcollins", AgentStatusType.AWAY));
		agentRepo.saveAndFlush(new Agent(null, "Terry Franco", "909-545-1234", "tfranco", AgentStatusType.ONLINE));
	}
	
	@After
	public void tearDown() {
		agentRepo.deleteAll();
	}
	
	@Test
	public void testThatAgentsExist() {
		List<Agent> agents = agentRepo.findAll();
		assertThat(agents.size(), is(4));
	}

}
