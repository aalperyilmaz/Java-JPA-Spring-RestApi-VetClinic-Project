package com.works.restapix.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ApiModel(value = "Buying Model", description = "Yeni Satın Alım Ekleme için Kullanılır.")

public class Buying {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bid", nullable = false)
    private Integer bid;

    @ApiModelProperty(value = "tname", required = true, notes = "tname belirtilmediğinde  servis hata verir!")
    private String tname;
    @ApiModelProperty(value = "product name ", required = true, notes = "pname belirtilmediğinde  servis hata verir!")
    private String pname;
    @ApiModelProperty(value = "buying note name ", required = false, notes = "bnote belirtilmediğinde  servis hata vermez!")
    private String bnote;
    private int proprice;
    private int proamount;
    private int probirim;
    private int taxtype;
    private int pdiscount;
    private int purtype;
    private int btotalPrice;
    private int bnetPrice;
    private int bgrossPrice;
    private int bfaturaNo;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date buyingDate;

    private int status;
}
