package at.refugeescode.encoder_ui.controller;

import at.refugeescode.encoder_ui.model.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Encoder {

    private RestTemplate restTemplate;

    @Value("${encoder.url}")
    private String encoderUrl;

    private String userMessage;

    private String encodedMessage;

    public Encoder(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void encode (Message message){
         userMessage = message.getText();
         encodedMessage = restTemplate.postForObject(encoderUrl, userMessage, String.class);
    }

    public String getEncodedMessage() {
        return encodedMessage;
    }

    public String getUserMessage() {
        return userMessage;
    }




}
