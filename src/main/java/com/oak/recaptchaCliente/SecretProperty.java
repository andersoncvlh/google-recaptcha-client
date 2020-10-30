package com.oak.recaptchaCliente;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter @Setter
@ConfigurationProperties(prefix = "google.recaptcha.secrets")
public class SecretProperty {

    private String v2;
    private String v3;

}
