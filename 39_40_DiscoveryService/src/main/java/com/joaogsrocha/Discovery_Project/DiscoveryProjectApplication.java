package com.joaogsrocha.Discovery_Project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DiscoveryProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryProjectApplication.class, args);
	}

}
