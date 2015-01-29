package com.pivotal.callme.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.thoughtworks.xstream.XStream;
import com.twilio.sdk.TwilioRestClient;

@Configuration
public class TwilioConfig implements EnvironmentAware {

	   private RelaxedPropertyResolver propertyResolver;
	   
	   public static final String ACCOUNT_SID = "account_sid";
	    public static final String AUTH_TOKEN = "auth_token";
	    
	    private Environment environment;

	    private final Logger log = LoggerFactory.getLogger(TwilioConfig.class);
	    
	    @Override
	    public void setEnvironment(Environment environment) {
	        this.environment = environment;
	        this.propertyResolver = new RelaxedPropertyResolver(environment, "twilio.");
	    }
	    
	    @Bean
	    public  XStream getXstreamObject() {
	    	XStream xstream = new XStream(); // DomDriver and StaxDriver instances also can be used in application
	    
	    	
	    	return xstream;
	    }
	    
    @Bean
    public TwilioRestClient twilioRestClient(){
    	   String account_sid = propertyResolver.getProperty(ACCOUNT_SID);
           String auth_token = propertyResolver.getProperty(AUTH_TOKEN);
           
           log.info("***************account_sid"+account_sid);
          TwilioRestClient client = new TwilioRestClient(account_sid, auth_token);
    	return client;
    }
    
 
}
