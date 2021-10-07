package com.works.restapix.properties;

import lombok.Data;

@Data
public class PassChange {
    private String email;
    private String oldPass;
    private String newPass;
}
