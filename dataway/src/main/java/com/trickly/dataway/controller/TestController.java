package com.trickly.dataway.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @Value("${jsch.proxy.user}")
    private String hello;

    @RequestMapping("/hello")
    public String from() {
        return this.hello;
    }
}
