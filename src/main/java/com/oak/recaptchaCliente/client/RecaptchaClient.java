package com.oak.recaptchaCliente.client;

import com.oak.recaptchaCliente.SecretProperty;
import com.oak.recaptchaCliente.model.CaptchaResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class RecaptchaClient {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    SecretProperty secretProperty;

    static final String URL = "https://www.google.com/recaptcha/api/siteverify";

    public ResponseEntity<CaptchaResponseDTO> siteVerifyV2(String token) {
        return getCaptchaResponseDTOResponseEntity(token, secretProperty.getV2());
    }
    public ResponseEntity<CaptchaResponseDTO> siteVerifyV3(String token) {
        return getCaptchaResponseDTOResponseEntity(token, secretProperty.getV3());
    }

    private ResponseEntity<CaptchaResponseDTO> getCaptchaResponseDTOResponseEntity(String token, String secret) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("secret", secret);
        map.add("response", token);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
        return restTemplate.exchange(URL,
                HttpMethod.POST,
                entity,
                CaptchaResponseDTO.class);
    }

}
