package com.pivotal.callme;


import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class CallmeController {

	@Value("${application.message:Hello World}")
	private String message = "Hello World";

	 	@RequestMapping("/twimlurl")
		public String welcome(Map<String, Object> model,HttpServletRequest request,HttpServletResponse response) {
			
		 	model.put("time", new Date());
			return "twiml";
		}
	 	
	 	
	 
	 
	 
	 

}
