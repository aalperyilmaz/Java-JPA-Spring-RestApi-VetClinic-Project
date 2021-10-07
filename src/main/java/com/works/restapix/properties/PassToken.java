package com.works.restapix.properties;

import lombok.Data;

@Data
public class PassToken {

    private String email;

    private String newPass;
    private String token;

}
