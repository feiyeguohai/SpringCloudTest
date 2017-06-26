package com.cloud.consumerfeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {

    @Autowired
    HelloServiceFeign helloService;
    
    @RequestMapping(value = "/hello")
    public String hi(@RequestParam String name){
        return helloService.sayHello(name);
    }

}