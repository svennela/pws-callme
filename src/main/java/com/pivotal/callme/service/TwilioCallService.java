package com.pivotal.callme.service;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pivotal.callme.bean.CallDetailsDTO;
import com.pivotal.callme.domain.HelpRequest;
import com.pivotal.callme.domain.RequestStatusType;
import com.pivotal.callme.repos.HelpRequestRepository;
import com.thoughtworks.xstream.XStream;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.resource.factory.CallFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.Call;

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
	@Autowired
	HelpRequestRepository helpRequestRepository;

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

    @Transactional
	public String processHelpRequest(HelpRequest helprequest) {
		// TODO Auto-generated method stub
		//check helprequest state make call only if it is queued...
		helprequest = helpRequestRepository.findOne(helprequest.getId());
		if(helprequest.getStatus().compareTo(RequestStatusType.QUEUED) == 0){
			//make call and update help request
			
			helprequest.setStatus(RequestStatusType.INPROGRESS);
			
			return "Call has being placed....get ready";
		}else if(helprequest.getStatus().compareTo(RequestStatusType.INPROGRESS) == 0){
			//make call and update help request
			
			helprequest.setStatus(RequestStatusType.COMPLETED);
			
			return "Thank you call for taking call.";
		}else{
			
			return "Invalid Request Status or Request has already being processed";
			
		}
		
		
		//return null;
	}

    
   
   
}
