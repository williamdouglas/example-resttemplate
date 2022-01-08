package com.example.exampleresttemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ExampleResttemplateApplication {
    private static final Logger logger = LoggerFactory.getLogger(ExampleResttemplateApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ExampleResttemplateApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) {
        return args -> {
            Endereco endereco = restTemplate.getForObject("https://viacep.com.br/ws/30855184/json/", Endereco.class);
            logger.info(endereco.toString());
        };
    }
}