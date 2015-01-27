package com.pivotal.callme.bean;

import java.util.List;

public class CallDetailsDTO {

    private String toPhoneNumber;
    private String fromPhoneNumber;
    
  

    public CallDetailsDTO() {
    }



	public String getToPhoneNumber() {
		return toPhoneNumber;
	}



	public void setToPhoneNumber(String toPhoneNumber) {
		this.toPhoneNumber = toPhoneNumber;
	}



	public String getFromPhoneNumber() {
		return fromPhoneNumber;
	}



	public void setFromPhoneNumber(String fromPhoneNumber) {
		this.fromPhoneNumber = fromPhoneNumber;
	}

   
}
