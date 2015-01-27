package com.pivotal.callme.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

@Profile("!cloud")
@Configuration
public class LocalDataSourceConfig implements EnvironmentAware {

	private RelaxedPropertyResolver propertyResolver;

	@Override
	public void setEnvironment(Environment environment) {
		this.propertyResolver = new RelaxedPropertyResolver(environment,
				"spring.datasource.");
	}

	@Bean
	public DataSource dataSource() {
		BasicDataSource dbcp = new BasicDataSource();
		dbcp.setDriverClassName(propertyResolver.getProperty("dataSourceClassName"));
		dbcp.setUrl(propertyResolver.getProperty("url"));
		dbcp.setUsername(propertyResolver.getProperty("username"));
		dbcp.setPassword(propertyResolver.getProperty("password"));
		return dbcp;
	}

}