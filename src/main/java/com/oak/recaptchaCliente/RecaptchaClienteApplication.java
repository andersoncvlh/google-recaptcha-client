package com.oak.recaptchaCliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.oak.recaptchaCliente")
@EnableConfigurationProperties(SecretProperty.class)
@SpringBootApplication
public class RecaptchaClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecaptchaClienteApplication.class, args);
	}

}
