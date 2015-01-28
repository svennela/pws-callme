package com.pivotal.callme;



import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pivotal.callme.domain.Agent;
import com.pivotal.callme.repos.AgentRepository;

@Controller
public class AgentController {
	
	private final Logger log = LoggerFactory.getLogger(AgentController.class);

	 	
		@Inject
		AgentRepository agentRepository;
	
	 	@ResponseBody
		@RequestMapping(value="/getagents", method=RequestMethod.GET)
		public List<Agent> getAgents() {
			
			return agentRepository.findAll();
			
		}
		
		
		
		@ResponseBody
		@RequestMapping(value="/createagent", method=RequestMethod.POST)
		public Agent creatAgent(@RequestBody Agent agent) {
		   
			log.info(agent.getFullname());
			return agentRepository.save(agent);
		}
	 
	 
	 

}
