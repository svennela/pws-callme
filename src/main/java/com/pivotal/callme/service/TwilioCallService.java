package com.pivotal.callme.service;

import org.apache.commons.lang.CharEncoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.pivotal.callme.bean.CallDetailsDTO;

import com.thoughtworks.xstream.XStream;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.resource.factory.CallFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.Call;
import com.twilio.sdk.resource.instance.Conference;
import com.twilio.sdk.resource.list.ConferenceList;
import com.twilio.sdk.verbs.Gather;
import com.twilio.sdk.verbs.Play;
import com.twilio.sdk.verbs.Say;
import com.twilio.sdk.verbs.TwiMLException;
import com.twilio.sdk.verbs.TwiMLResponse;

import javax.inject.Inject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Service for sending e-mails.
 * <p/>
 * <p>
 * We use the @Async annotation to send e-mails asynchronously.
 * </p>
 */
@Service
public class TwilioCallService {

    private final Logger log = LoggerFactory.getLogger(TwilioCallService.class);

   
    @Inject
    private TwilioRestClient twilioRestClient;

    @Inject
    private XStream xstream;
    

    @Async
    public void makeOutboundCall(CallDetailsDTO calldetails) {
       
        
      
        try {
        	 Account mainAccount = twilioRestClient.getAccount();
        	 
        	 					
             CallFactory callFactory = mainAccount.getCallFactory();
             Map<String, String> callParams = new HashMap<String, String>();
             callParams.put("To", calldetails.getToPhoneNumber()); // Replace with your phone number
             callParams.put("From", calldetails.getFromPhoneNumber()); // Replace with a Twilio number
            // callParams.put("Url", "http://demo.twilio.com/welcome/voice/");
             callParams.put("Url", "http://pws-twilio.cfapps.io/twimlurl/");
            
             // Make the call
             Call call = callFactory.create(callParams);
             // Print the call SID (a 32 digit hex like CA123..)
             System.out.println(call.getSid());
           
        } catch (Exception e) {
            log.warn("E-mail could not be sent to user '{}', exception is: {}", calldetails, e.getMessage());
        }
    }

    
   
   
}
