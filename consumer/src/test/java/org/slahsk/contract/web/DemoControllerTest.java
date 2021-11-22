package org.slahsk.contract.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = DemoController.class)
@AutoConfigureStubRunner(ids ={"org.slahsk.contract:producer-contract:+:stubs:8080"})
public class DemoControllerTest {


    @Autowired
    private WebTestClient webClient;


    @Test
    public void testGet(){
        webClient.get()
                .uri("/get")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.name").isEqualTo("홍길동");


    }

}
