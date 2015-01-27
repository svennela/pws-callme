package com.pivotal.callme.domain;
import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "T_AGENT")
public class Agent  implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

}
