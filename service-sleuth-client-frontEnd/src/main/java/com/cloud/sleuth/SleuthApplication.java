package com.cloud.sleuth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class SleuthApplication {

	private static Logger log = LoggerFactory.getLogger(SleuthApplication.class);

	@RequestMapping("/hello")
	public String home(String name) {
		log.info("Handling home");
		return "i am frontEnd.Hello World " + name;
	}
	
	@Autowired
    private RestTemplate restTemplate;

	
	/*
	 *  @LoadBalanced is needed， or it will not recognize  service name in restTemplate url.
	 */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
	
    @RequestMapping("/call")
	public String callBackEnd(String name)
	{
    	log.info("call trace back end!");
    	return restTemplate.getForObject("http://SERVICE-SLEUTH-CLIENT-BACKEND/answer?name="+name, String.class);
	}
	

	public static void main(String[] args) {
		SpringApplication.run(SleuthApplication.class, args);
	}
}
