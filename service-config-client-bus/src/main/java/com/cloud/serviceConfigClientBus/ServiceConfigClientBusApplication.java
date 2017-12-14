package com.cloud.serviceConfigClientBus;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
@RefreshScope
public class ServiceConfigClientBusApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceConfigClientBusApplication.class, args);
	}
	
	
	@Value("${from}")
    String from;
    

    @RequestMapping(value = "/hi")
    public String hi(){
        return from;
    }
	
	
}
