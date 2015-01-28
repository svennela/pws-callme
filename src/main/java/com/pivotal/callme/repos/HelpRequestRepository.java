package com.pivotal.callme.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.pivotal.callme.domain.HelpRequest;

public interface HelpRequestRepository extends JpaRepository<HelpRequest, Long> {

}
