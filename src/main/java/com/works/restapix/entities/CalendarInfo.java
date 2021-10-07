package com.works.restapix.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
@ApiModel(value = "Clender info Model", description = "Yeni Takvim Ekleme için Kullanılır.")

@Entity
@Data
public class CalendarInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid", nullable = false)
    private Integer cid;
    @ApiModelProperty(value = " cname Clalener name ", required = true, notes = "cname belirtilmediğinde  servis hata verir!")
    private String cname;
    private String ccolor;
    private String cbgColor;
    private String cdragBgColor;
    private String cborderColor;

}
