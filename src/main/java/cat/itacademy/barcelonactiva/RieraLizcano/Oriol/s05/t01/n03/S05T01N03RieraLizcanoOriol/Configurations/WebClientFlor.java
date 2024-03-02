package cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s05.t01.n03.S05T01N03RieraLizcanoOriol.Configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientFlor {

    @Bean
    public WebClient webClient (){
        return WebClient.builder().build();
    }



}
