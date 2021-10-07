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
@ApiModel(value = "Lab Model", description = "Yeni Lab sonucu Ekleme için Kullanılır.")

public class Lab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lid", nullable = false)
    private Integer lid;
    @ApiModelProperty(value = "lab title Adı", required = false )

    private String ltitle;
    @ApiModelProperty(value = "Müşteri Adı", required = false)
    private String lcomment;

    @ApiModelProperty(value = "Pet object", required = true, notes = "Pet object belirtilmediğinde  servis hata verir!")

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pid")
    private Pet pid;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ldate;
    @ApiModelProperty(value = "file name", required = true, notes = "file name belirtilmediğinde  servis hata verir!")
    private String fileName;

}
