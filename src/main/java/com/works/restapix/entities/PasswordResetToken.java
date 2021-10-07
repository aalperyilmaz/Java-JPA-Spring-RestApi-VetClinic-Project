package com.works.restapix.entities;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class PasswordResetToken {
    private static final int EXPIRATION = 60 * 24;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ApiModelProperty(value = "Şifre değiştirmek için gerekli token döner", required = true)

    private String token;

    @ApiModelProperty(value = "User object", required = true)

    @OneToOne( fetch = FetchType.LAZY)
    @JoinColumn( name = "user_id")
    private User user;

    private Date expiryDate;



}
