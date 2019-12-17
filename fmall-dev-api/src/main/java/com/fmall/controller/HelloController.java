package com.fmall.controller;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Hello Amundsen")
@RestController
public class HelloController {

    @GetMapping("/hello")
    public Object hello() {
        return "<h1>Hello World...</h1>";
    }

}
