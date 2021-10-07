package com.works.restapix.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;



@Getter
@Setter
@ApiModel(value = "Customer Model", description = "Yeni Müşteri Ekleme için Kullanılır.")

@Entity
@JsonIgnoreProperties
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid", nullable = false)
    private Integer cid;

    @ApiModelProperty(value = "Müşteri Adı", required = true, notes = "Name belirtilmediğinde  servis hata verir!")
    @NotNull(message = "Name parametresi null olamaz!")
    @NotEmpty(message = "Bu alan boş olamaz!")
    @Length(min = 2, max = 100, message = "Name min = 2, max = 100")
    private String cname;

    @ApiModelProperty(value = "Müşteri Soy Adı", required = true, notes = "Soyadı belirtilmediğinde  servis hata verir!")
    @NotNull(message = "Surname parametresi null olamaz!")
    @NotEmpty(message = "Bu alan boş olamaz!")
    private String csurname;

    @ApiModelProperty(value = "Müşteri Telefonu", required = false, notes = "Belirtilmesi tavsiye edilir")
    private String ctel;
    @ApiModelProperty(value = "Müşteri Telefonu", required = false, notes = "Belirtilmesi tavsiye edilir")
    private String ctel_2;

    @ApiModelProperty(value = "Müşteri Email", required = true, notes = "Email belirtilmediğinde   servis hata verir!")
    @NotNull(message = "Email parametresi null olamaz!")
    @NotEmpty(message = "Bu alan boş olamaz!")
    @Email(message = "E-Mail formatı hatalı!")
    private String cmail;

    @ApiModelProperty(value = "Müşteri Vergi dairesi", required = false, notes = "Belirtilmesi tavsiye edilir")
    private String ctax_office;
    private String cnote;

    @ApiModelProperty(value = "Müşteri vatandaşlık numarası", required = false, notes = "Belirtilmesi tavsiye edilir")
    private Integer ccitizenship;

    @ApiModelProperty(value = "Müşteri indirim tutarı", required = false, notes = "Belirtilmesi tavsiye edilir")
    private Integer cdiscount;

    @ApiModelProperty(value = "Müşteri şehri", required = false, notes = "Belirtilmesi tavsiye edilir")
    private String ccity;
    private String ctown;
    private String caddress;

    @ApiModelProperty(value = "Müşteri tarih", required = false, notes = "Belirtilmesi tavsiye edilir")
    private String cdate;

    @ApiModelProperty(value = "Müşteri bakiyesi", required = false, notes = "Tedavi sonucu oluşacak bakiye")
    private Integer cdebpt;


   @JsonManagedReference
    @OneToMany(mappedBy = "cid", fetch = FetchType.LAZY,
            cascade = CascadeType.DETACH ,orphanRemoval = true)
    private List<Pet> pets;
}
