package com.cloud.servicesleuthclientbackEnd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ServiceSleuthClientBackEndApplication {
	
	private static Logger log = LoggerFactory.getLogger(ServiceSleuthClientBackEndApplication.class);
	
	
	@RequestMapping("/hello")
	public String home(String name) {
		log.info("Handling home");
		return "i am backEnd.Hello World " + name;
	}
	
	@Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
	
    @RequestMapping("/answer")
	public String answerFrontEnd(String name)
	{
    	log.info("answer trace front end call!");
    	return "answer front end call: your name is " + name;
	}
	

	public static void main(String[] args) {
		SpringApplication.run(ServiceSleuthClientBackEndApplication.class, args);
	}
}
