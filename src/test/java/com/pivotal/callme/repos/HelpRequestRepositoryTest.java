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
import com.pivotal.callme.domain.HelpRequest;
import com.pivotal.callme.domain.RequestType;
import com.pivotal.callme.domain.RequestStatusType;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		classes={RepoTestConfig.class, LocalDataSourceConfig.class}, 
		initializers=ConfigFileApplicationContextInitializer.class)
public class HelpRequestRepositoryTest {

	@Autowired
	HelpRequestRepository hrRepo;

	@Before
	public void setUp() {
		hrRepo.saveAndFlush(new HelpRequest(null, "Joe User", "555-555-5785", "joe@users.com", "juser", "I'm having a problem.",
				RequestType.PHONE,RequestStatusType.QUEUED));
		hrRepo.saveAndFlush(new HelpRequest(null, "Sally User", "555-555-1234", "sally@users.com", "suser", "I need some help."
				, RequestType.IM,RequestStatusType.QUEUED));
		
	}
	
	@After
	public void tearDown() {
		hrRepo.deleteAll();
	}
	
	@Test
	public void testThatAgentsExist() {
		List<HelpRequest> hrs = hrRepo.findAll();
		assertThat(hrs.size(), is(2));
	}

}
