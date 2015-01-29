package com.pivotal.callme.web;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pivotal.callme.domain.HelpRequest;
import com.pivotal.callme.repos.HelpRequestRepository;

@RestController
@RequestMapping("/helprequests")
public class HelpRequestController {

	private static final Logger log = LoggerFactory.getLogger(AgentController.class);
	
	@Autowired
	HelpRequestRepository helpRequestRepository;

	@RequestMapping(method=RequestMethod.GET)
	public List<HelpRequest> get() {
		return helpRequestRepository.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public HelpRequest post(@RequestBody HelpRequest helprequest) {
		log.info("Created: " + helprequest);
		return helpRequestRepository.save(helprequest);
	}

}
