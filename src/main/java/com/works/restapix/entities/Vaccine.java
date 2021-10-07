package com.works.restapix.entities;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
@JsonDeserialize(contentAs =  Vaccine.class)
@Entity
@Data
@ApiModel(value = "Vacc Model", description = "Yeni Aşı Ekleme için Kullanılır.")

@Table(name="vaccine")
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacid", nullable = false)
    private Integer vacid;

    @ApiModelProperty(value = "Aşı  Adı", required = true, notes = "vaccname belirtilmediğinde  servis hata verir!")
    @NotNull(message = "Name parametresi null olamaz!")
    @NotEmpty(message = "Bu alan boş olamaz!")
    @Length(min = 2, max = 150, message = "Name min = 2, max = 100")
    private String vacname;
    @ApiModelProperty(value = "Aşı miktarı Adı", required = false)
    private Integer vacunit;
    @ApiModelProperty(value = "Aşı türü", required = false)

    private Integer vactype;
    @ApiModelProperty(value = "Aşı Kategorisi", required = false)

    private Integer vaccategory;
    @ApiModelProperty(value = "Aşı Tedarikçileri", required = false)

    private Integer vacsupplier;
    @ApiModelProperty(value = "Aşı Barkodu", required = false)

    private String vacbarcode;
    @ApiModelProperty(value = "Aşı kodu", required = false)

    private String vaccode;
    @ApiModelProperty(value = "Aşı alış miktarı", required = false)

    private Integer vacbuying;
    @ApiModelProperty(value = "Aşı Satiş miktarı", required = false)

    private Integer vacsales;
    @ApiModelProperty(value = "Aşı Vergi", required = false)

    private Integer vactax;
    @ApiModelProperty(value = "Aşı vergi dahil mi?", required = false)

    private Integer vactaxincluded;
    @ApiModelProperty(value = "Aşı stok miktarı", required = false)

    private Integer vacstock;
    @ApiModelProperty(value = "Aşı aktif mi?", required = false)

    private Integer vacactive;
    @ApiModelProperty(value = "Aşı hayvan türü", required = false)

    private Integer vacpettype;
    @ApiModelProperty(value = "Aşı tekrar sayısı", required = false)

    private Integer vacrepeat;

    @JsonIgnore
    @OneToMany(mappedBy = "stvac", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Storage> storages;

}
