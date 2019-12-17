package com.fmall.controller;


import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Hello Amundsen")
@RestController
public class HelloController {

    final static Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public Object hello() {
//        LOGGER.debug("---> debug: hello world");
//        LOGGER.info("---> info: hello world");
//        LOGGER.warn("---> warn: hello world");
//        LOGGER.error("---> error: hello world");
        return "<h1>Hello World...</h1>";
    }

}
