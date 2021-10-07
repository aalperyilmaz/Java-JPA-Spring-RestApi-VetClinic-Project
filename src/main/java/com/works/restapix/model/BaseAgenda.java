package com.works.restapix.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class BaseAgenda {

    @Id
    private String id;

    private String agtitle;
    private String agtext;
    private String agdate;
    private String agtime;
}
