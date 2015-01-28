package com.pivotal.callme.domain;
import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "T_HELPREQUEST")
public class HelpRequest implements Serializable {
	private static final long serialVersionUID = 8710546556554995509L;

	@Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String fullname;
    
    @Column
    private String phone;
    
    @Column
    private String email;
    
    @Column(nullable = false)
    private String username;
    
    @Column
    private String description;
    
    @Column(name="request_type")
    @Enumerated(EnumType.STRING)
    private RequestType status;

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public RequestType getStatus() {
		return status;
	}

	public void setStatus(RequestType status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
