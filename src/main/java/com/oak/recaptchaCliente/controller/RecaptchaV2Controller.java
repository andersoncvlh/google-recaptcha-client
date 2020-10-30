package com.oak.recaptchaCliente.controller;

import com.oak.recaptchaCliente.model.CaptchaResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("v2/verify")
public class RecaptchaV2Controller {

    @Autowired
    private com.oak.recaptchaCliente.client.RecaptchaClient recaptchaClient;

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<CaptchaResponseDTO> recaptchaV2(@RequestParam String token) {
        return recaptchaClient.siteVerifyV2(token);
    }

    @GetMapping
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Ok");
    }

}
