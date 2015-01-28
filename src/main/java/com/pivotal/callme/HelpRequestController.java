package com.pivotal.callme;


import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
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
