package com.pivotal.callme;


import java.util.Date;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pivotal.callme.bean.ResponseMessage;
import com.pivotal.callme.domain.HelpRequest;
import com.pivotal.callme.service.TwilioCallService;

@Controller
public class CallmeController {

		private static final Logger log = LoggerFactory.getLogger(CallmeController.class);
	
		@Inject
		TwilioCallService twilioCallService;
		
	 	@RequestMapping("/twimlurl/{calltoken}")
		public String welcome(@PathVariable String calltoken,Map<String, Object> model,HttpServletRequest request,HttpServletResponse response) {
			log.info(calltoken);
		 	model.put("time", new Date());
			return "twiml";
		}
	 	
	 	
	 	@RequestMapping(value = "/callme", method = RequestMethod.POST,headers={"token=pwstoken"})
		public ResponseEntity<ResponseMessage> post(@RequestBody HelpRequest helprequest) {
			
	 		String message = twilioCallService.processHelpRequest(helprequest);
	 		//ResponseMessage response = new ResponseMessage();
	 		ResponseMessage response = new ResponseMessage();
	 		response.setMessage(message);
	 		return new ResponseEntity<>(
	 				response,
	 	            HttpStatus.OK);
			
			
			
			
		}

}

