package com.pivotal.callme.web;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pivotal.callme.domain.HelpRequest;
import com.pivotal.callme.domain.RequestStatusType;
import com.pivotal.callme.repos.HelpRequestRepository;

@RestController
@RequestMapping("/helprequests")
public class HelpRequestController {

	private static final Logger log = LoggerFactory.getLogger(AgentController.class);
	
	@Autowired
	HelpRequestRepository helpRequestRepository;

	@Value("${helprequests.magic_token}")
	private String MAGIC_TOKEN;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<HelpRequest> get() {
		return helpRequestRepository.findAll();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public HelpRequest getOne(@PathVariable Long id, HttpServletResponse response) {
		log.info("Getting [" + id + "]");
		HelpRequest hr = helpRequestRepository.findOne(id);
		if (hr == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		return hr;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void post(@RequestBody HelpRequest helprequest, 
					 @RequestHeader(value="X-Security-Token", defaultValue="") String token,
					 HttpServletResponse response) {
		if (MAGIC_TOKEN.equals(token)) {
			log.info("Created: " + helprequest);
			
			helprequest.setStatus(RequestStatusType.QUEUED);
			helpRequestRepository.save(helprequest);
			
			response.setStatus(HttpServletResponse.SC_CREATED);
			response.setHeader("Location", "http://localhost:8080/helprequest/" + helprequest.getId());
		} else {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

}
