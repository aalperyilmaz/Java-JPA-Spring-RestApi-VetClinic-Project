package com.works.restapix.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Logger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lid", nullable = false)
    private Integer lid;

    private String lname;
    private String lsurname;
    private String lemail;
    private String lsessionId;
    private String lIp;
    private String lroles;
    private String lUrl;
    private LocalDateTime lDate;
}
