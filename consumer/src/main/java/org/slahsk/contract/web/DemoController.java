package org.slahsk.contract.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class DemoController {


    @GetMapping("/get")
    public Mono<String> getDemo(){
        WebClient client = WebClient.create();
        Mono<String> result = client.get()
                .uri("http://localhost:8080/users/1")
                .retrieve()
                .bodyToMono(String.class);


        return result;
    }
}
