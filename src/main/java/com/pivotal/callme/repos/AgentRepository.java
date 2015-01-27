package com.pivotal.callme.repos;

import org.springframework.data.repository.CrudRepository;

import com.pivotal.callme.domain.Agent;

public interface AgentRepository extends CrudRepository<Agent, Long>{

}
