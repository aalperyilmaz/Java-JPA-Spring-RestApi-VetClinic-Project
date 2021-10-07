package com.works.restapix.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ApiModel(value = "Cure Model", description = "Yeni Tedavi Ekleme için Kullanılır.")

@JsonSerialize
public class Cure {
    @Id
    @Column(name = "curid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer curid;
    @ApiModelProperty(value = "Tedavi Adı", required = true, notes = "Tedavi belirtilmediğinde  servis hata verir!")

    private String curtitle;
    private String curcomment;
    private Integer curdebt;

    @ApiModelProperty(value = "Pet Nesnesi", required = true, notes = "Pet nesnesi belirtilmediğinde  servis hata verir!")

    @OneToOne
    private  Pet pet;

    @ApiModelProperty(value = "Vacc Adı", required = false, notes = "Vacc belirtilmediğinde  servis hata verir!")

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "curvac")
    private Vaccine curvac;
    @ApiModelProperty(value = "Müşteri Adı", required = false)

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "curpro")
    private Product curpro;
    @ApiModelProperty(value = "Labor (hizmet) adı", required = false, notes = "hizmet adı belirtilmediğinde  servis hata vermez!")

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "curla")

    private Labor curla;


}
