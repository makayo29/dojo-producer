package com.example.dojoproducer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {

    private final Producer producer;


    public DojoController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping("/v1/publish")
    public void publish(@RequestBody String msg){
        this.producer.sendMessage(msg);
    }

}
