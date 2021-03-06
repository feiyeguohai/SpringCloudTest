package com.cloud.serviceConfigClientEureka;

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
public class ServiceConfigClientEurekaApplication {
    
    
    /*
     * 
     
     @RefreshScope  注解加上后 ， 通过POST请求发送到http://localhost:7003/admin/refresh，才会更新from值
     
     
     
     * 
     */
    

	public static void main(String[] args) {
		SpringApplication.run(ServiceConfigClientEurekaApplication.class, args);
	}
	
	@Value("${from}")
    String from;
	
    @RequestMapping(value = "/hi")
    public String hi(){
        return from;
    }
	
	
}
