package com.pivotal.callme;


import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pivotal.callme.domain.HelpRequest;
import com.pivotal.callme.repos.HelpRequestRepository;

@Controller
public class HelpRequestController {

	@Inject
	HelpRequestRepository helpRequestRepository;

 	@ResponseBody
	@RequestMapping(value="/gethelprequests", method=RequestMethod.GET)
	public List<HelpRequest> gethelprequest() {
		
		return helpRequestRepository.findAll();
		
	}
	
	@ResponseBody
	@RequestMapping(value="/creathelprequests", method=RequestMethod.POST)
	public HelpRequest createhelprequest(@RequestBody HelpRequest helprequest) {
	
		return helpRequestRepository.save(helprequest);
	}

}
