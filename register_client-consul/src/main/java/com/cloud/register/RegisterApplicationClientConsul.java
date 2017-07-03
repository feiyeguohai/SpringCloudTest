package com.cloud.register;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@RestController
@SpringBootApplication
public class RegisterApplicationClientConsul {

    @RequestMapping("/")
    public String home() {
        return "Hello world";
    }

    
    /*
     * 
              可以通过consul的api访问服务：同个service name可以有多个service instance
     http://localhost:8500/v1/catalog/service/consule-hello-client
     * 
     */
    
    public static void main(String[] args) {
        new SpringApplicationBuilder(RegisterApplicationClientConsul.class).web(true).run(args);
    }

}
