package com.deory.webfluxapp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@RestController
public class TestController {

    private static final WebClient client = WebClient.builder().baseUrl("http://localhost:8080").build();

    @PostMapping("/**")
    public Mono<String> testPost(@RequestBody String body) {
        return client.post()
                .uri("/test")
                .bodyValue(body)
                .exchangeToMono(clientResponse ->
                        clientResponse.bodyToMono(String.class)
                );
    }

    @PutMapping("/**")
    public Mono<String> testPut(@RequestBody String body) {
        return client.put()
                .uri("/test")
                .bodyValue(body)
                .exchangeToMono(clientResponse ->
                        clientResponse.bodyToMono(String.class)
                );
    }
}
