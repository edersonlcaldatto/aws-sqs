package com.example.awssqs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.awssqs.producer.AwsSQSProducerService;

@RestController
@RequestMapping
public class AwsSQSController {

    @Autowired
    private AwsSQSProducerService awsSQSProducerService;

    @GetMapping("/{msg}")
    public void sendMessage(@PathVariable String msg) {

        awsSQSProducerService.sendMessage(msg);
    }


}
