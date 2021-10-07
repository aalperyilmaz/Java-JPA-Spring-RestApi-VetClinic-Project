package com.works.restapix.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


    @Entity
    @Getter
    @Setter
    @ApiModel(value = "Labor Model", description = "Yeni Hizmet Ekleme için Kullanılır.")

    public class Labor {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "laid", nullable = false)
        private Integer laid;

        @ApiModelProperty(value = "Hizmet Adı", required = false)
        private String laname;
        @ApiModelProperty(value = "Hizmet ücreti", required = false)

        private Integer lamoney;
    }

