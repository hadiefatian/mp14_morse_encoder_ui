package at.refugeescode.encoder_ui.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfigutation {

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
