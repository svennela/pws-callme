package com.pivotal.twilio;



import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pivotal.callme.Application;
import com.pivotal.callme.bean.CallDetailsDTO;
import com.pivotal.callme.service.TwilioCallService;

@RunWith(SpringJUnit4ClassRunner.class)
@Profile("dev")
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ApplicationTests {

	@Inject
	TwilioCallService twilioCallService;
	

	@Test
	public void testCall() {
		CallDetailsDTO calldetails = new CallDetailsDTO();
		calldetails.setToPhoneNumber("afasfsdf"); 
		calldetails.setFromPhoneNumber("(650) 362-8809");
		twilioCallService.makeOutboundCall(calldetails);
	}
	


}
