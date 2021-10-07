package com.works.restapix.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@JsonIgnoreProperties
@Getter
@Setter
@Entity
@ApiModel(value = "Pet Model", description = "Yeni Pet Ekleme için Kullanılır.")

@Table
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pid", nullable = false)
    private Integer pid;

    @ApiModelProperty(value = "Pet Adı", required = true, notes = "Name belirtilmediğinde  servis hata verir!")
    @NotNull(message = "Name parametresi null olamaz!")
    @NotEmpty(message = "Bu alan boş olamaz!")
    private String pname;

    @ApiModelProperty(value = "Pet chip numarası", required = false, notes = "Belirtilmesi tavsiye edilir")
    private Integer pchip;
    @ApiModelProperty(value = "Pet küpe numarası", required = false, notes = "Belirtilmesi tavsiye edilir")
    private String pearnumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pbirthday;
    @ApiModelProperty(value = "Pet chip numarası", required = false, notes = "Belirtilmesi tavsiye edilir")
    private Integer ptype;
    private Integer pspay;
    private String prace;
    private Integer pcolor;
    private Integer pgender;

    @JsonBackReference

    @ManyToOne(fetch = FetchType.LAZY, optional = false,cascade = CascadeType.DETACH)
    @JoinColumn(name = "cid", nullable = false)
    private Customer cid;

}
