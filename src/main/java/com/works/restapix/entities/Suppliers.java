package com.works.restapix.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ApiModel(value = "Suppliers Model", description = "Yeni Tedarikçi Ekleme için Kullanılır.")

public class Suppliers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "suid", nullable = false)
    private Integer suid;

    @ApiModelProperty(value = "Tedarikçi Adı", required = true, notes = "sname belirtilmediğinde  servis hata verir!")
    private String suname;
    @ApiModelProperty(value = "Tdarikçi mail ", required = true, notes = "smail belirtilmediğinde  servis hata verir!")
    private String sumail;
    @ApiModelProperty(value = "Tedarikçi tel ", required = true, notes = "sutel belirtilmediğinde  servis hata verir!")
    private String sutel;
    @ApiModelProperty(value = "Tedarikçi durumu aktif/pasif", required = true, notes = "suactive belirtilmediğinde  servis hata verir!")
    private Integer suactive;
    @ApiModelProperty(value = "Tedarikçi alacak/verecek", required = true, notes = "sudebt belirtilmediğinde  servis hata verir!")
    private Integer sudebt;


}
