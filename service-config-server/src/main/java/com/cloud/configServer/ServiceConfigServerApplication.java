package com.cloud.configServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ServiceConfigServerApplication {
    
    
    /*
     * 
     
     URL与配置文件的映射关系如下：

/{application}/{profile}[/{label}]
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties
上面的url会映射{application}-{profile}.properties对应的配置文件，{label}对应git上不同的分支，默认为master。
     
     jvm增加参数：  -Dhttps.proxyHost=localhost -Dhttps.proxyPort=3128
     
     
     */

	public static void main(String[] args) {
		SpringApplication.run(ServiceConfigServerApplication.class, args);
	}
}
