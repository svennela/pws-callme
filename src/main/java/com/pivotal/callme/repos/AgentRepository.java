package com.pivotal.callme.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pivotal.callme.domain.Agent;

public interface AgentRepository extends JpaRepository<Agent, Long>{

}
