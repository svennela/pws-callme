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
    private StatusType status;
}
