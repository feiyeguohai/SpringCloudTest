package com.cloud.consul;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@RestController
@SpringBootApplication
@EnableFeignClients
public class RegisterApplicationConsumerConsul {

    
    /*
     * 
         本例支持ribbon 和 feign 两种方式消费
     * 
     * 
     */
    
    @Autowired  
    private LoadBalancerClient loadBalancer;  
      
    @Autowired  
    private DiscoveryClient discoveryClient;  
    
    @Autowired
    RestTemplate restTemplate;
    
    @Value("${service.name}")
    private String service;
    
    @Value("${spring.application.name}")
    private String appName;
    
    @Autowired
    private SampleClient sampleClient;
    

    public static void main(String[] args) {
        new SpringApplicationBuilder(RegisterApplicationConsumerConsul.class).web(true).run(args);
    }
    
    
    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
    
    
      
    /** 
     * 从所有服务中选择一个服务（轮询） 
     */  
    @RequestMapping("/discover")  
    public Object discover() {  
        return loadBalancer.choose(service).getUri().toString();  
    }  
    
    @RequestMapping("/hello")
    public String sayHello(@RequestParam String name) {
        
        return "call via consumer:  " + restTemplate.getForObject("http://"+service+"/hello?name="+name, String.class);
                
    }
    
      
    /** 
     * 获取所有服务  
     */  
    @RequestMapping("/services")  
    public Object services() {  
        return discoveryClient.getInstances("consule-hello-client");  
    }  
    
    
    
    @RequestMapping("/me")
    public ServiceInstance me() {
        return discoveryClient.getLocalServiceInstance();
    }

    @RequestMapping("/")
    public ServiceInstance lb() {
        return loadBalancer.choose(appName);
    }

    @RequestMapping("/rest")
    public String rest() {
        return this.restTemplate.getForObject("http://"+appName+"/me", String.class);
    }

    @RequestMapping("/choose")
    public String choose() {
        return loadBalancer.choose(appName).getUri().toString();
    }


    @RequestMapping("/instances")
    public List<ServiceInstance> instances() {
        return discoveryClient.getInstances(appName);
    }

    @RequestMapping("/feign")
    public String feign() {
        return sampleClient.choose();
    }


    @FeignClient("consul-consumer")
    public interface SampleClient {

        @RequestMapping(value = "/choose", method = RequestMethod.GET)
        String choose();
    }
    
    

}
