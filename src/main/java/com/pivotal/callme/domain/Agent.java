package com.pivotal.callme.domain;
import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "T_AGENT")
public class Agent  implements Serializable {
	private static final long serialVersionUID = -4025296509622634162L;
	
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String fullname;
    
    @Column(nullable = false)
    private String phone;
    
    @Column(nullable = false)
    private String username;
    
    @Column(name="status_type")
    @Enumerated(EnumType.STRING)
    private AgentStatusType status;

    public Agent() {}
    
	public Agent(Long id, String fullname, String phone, String username, AgentStatusType status) {
		this.id = id;
		this.fullname = fullname;
		this.phone = phone;
		this.username = username;
		this.status = status;
	}

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public AgentStatusType getStatus() {
		return status;
	}

	public void setStatus(AgentStatusType status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Agent [id=" + id + ", fullname=" + fullname + ", phone="
				+ phone + ", username=" + username + ", status=" + status + "]";
	}
	
}
