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
@ApiModel(value = "Sale Model", description = "Yeni Satış Ekleme için Kullanılır.")

public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sid", nullable = false)
    private Integer sid;
    @ApiModelProperty(value = "Satış Durumu Adı", required = true, notes = "Status belirtilmediğinde  servis hata verir!")

    private boolean status;
    @ApiModelProperty(value = "Müşteri Adı", required = true, notes = "Name belirtilmediğinde  servis hata verir!")

    private String cname;
    @ApiModelProperty(value = "Ürün Adı", required = true, notes = "pname belirtilmediğinde  servis hata verir!")

    private String pname;
    @ApiModelProperty(value = "Fatura no", required = true, notes = "faturaNo belirtilmediğinde  servis hata verir!")

    private int faturaNo;
   private int pprice;

   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private Date saleDate;

   @Column(length = 250)
   private String note;

   private int totalPrice;
   private int pamount;
   private int grossPrice;
   private int netPrice;
   private int proType;
   private int tax_type;
   private int pdiscount;
   private int purType;

}
