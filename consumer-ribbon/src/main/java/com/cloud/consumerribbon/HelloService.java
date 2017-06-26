package com.cloud.consumerribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod="fallback")
    public String hiService(String name) {
        return restTemplate.getForObject("http://HELLOSERVICE/hello?name="+name,String.class);
    }

    
    public String fallback(String name){
        return "sorry, " + name + " , service is not available.";
    }
}