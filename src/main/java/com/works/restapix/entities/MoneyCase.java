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
@ApiModel(value = "MoneyCase Model", description = "Yeni Kasa Hareketi Ekleme için Kullanılır.")

public class MoneyCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid", nullable = false)
    private Integer cid;

    @ApiModelProperty(value = "Para giriş/çıkış miktarı", required = true)

    private Integer cmoney;
    @ApiModelProperty(value = "Para giriş/çıkış türü", required = false)
    private Integer cbuysell; // 1 buy ekleme | 2 sell çıkarma
    @ApiModelProperty(value = "Kasa hareketi Tarihi", required = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cdatenow;
    @ApiModelProperty(value = "Para giriş/çıkış isim", required = false)
    private String cpeople;
    private String cname;
    @ApiModelProperty(value = "Para giriş/çıkış notu", required = false)
    private String ccomment;
}
