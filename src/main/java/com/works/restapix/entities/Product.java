package com.works.restapix.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="product")
@ApiModel(value = "Prouct Model", description = "Yeni Product Ekleme için Kullanılır.")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prid", nullable = false)
    private Integer prid;

    @NotNull(message = "Name parametresi null olamaz!")
    @NotEmpty(message = "Bu alan boş olamaz!")
    @Length(min = 2, max = 150, message = "Name min = 2, max = 100")
    private String prname;

    @ApiModelProperty(value = "Para giriş/çıkış miktarı", required = false)

    private Integer prunit;
    @ApiModelProperty(value = "Prouct type", required = false)
    private Integer prtype;
    @ApiModelProperty(value = "Prouct Category", required = false)

    private Integer prcategory;
    @ApiModelProperty(value = "Prouct Supplier", required = false)

    private Integer prsupplier;
    @ApiModelProperty(value = "Product barcode", required = false)

    private String prbarcode;
    @ApiModelProperty(value = "Ürün kodu", required = false)

    private String prcode;
    @ApiModelProperty(value = "Product Alış", required = false)

    private Integer prbuying;
    @ApiModelProperty(value = "Product Satış", required = false)

    private Integer prsales;
    @ApiModelProperty(value = "Product Vergi miktarı", required = false)

    private Integer prtax;
    @ApiModelProperty(value = "Para giriş/çıkış miktarı", required = false)

    private Integer practive;
    @ApiModelProperty(value = "Vergi dahil fiyat", required = false)

    private Integer prtaxincluded;
    @ApiModelProperty(value = "stok miktarı", required = false)

    private Integer prstock;



    @JsonIgnore
    @OneToMany(mappedBy = "stpro", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Storage> storages;


}
