package com.pivotal.callme.repos;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackages={"com.pivotal.callme.domain"})
@ComponentScan(basePackages={"com.pivotal.callme.repos"})
@EnableAutoConfiguration
public class RepoTestConfig {
}
