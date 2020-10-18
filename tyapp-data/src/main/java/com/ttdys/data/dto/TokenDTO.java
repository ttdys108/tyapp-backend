package com.ttdys.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenDTO {

    private String token;
    //seconds
    private Integer expiresIn;

    private String refreshToken;

}
