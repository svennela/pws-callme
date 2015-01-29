package com.pivotal.callme;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pivotal.callme.domain.Agent;
import com.pivotal.callme.repos.AgentRepository;

@RestController
@RequestMapping("/agents")
public class AgentController {

	private static final Logger log = LoggerFactory.getLogger(AgentController.class);

	@Autowired
	AgentRepository agentRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Agent> getAgents() {
		return agentRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Agent creatAgent(@RequestBody Agent agent) {
		log.info("Creating " + agent);
		return agentRepository.save(agent);
	}

}
