package com.oak.recaptchaCliente.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter@Setter
@NoArgsConstructor
public class CaptchaResponseDTO implements Serializable {

    private boolean success;
    @JsonProperty(value = "error-codes")
    private String[] errorCodes;

}
