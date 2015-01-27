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
}
