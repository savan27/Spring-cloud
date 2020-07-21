package com.savan.userservice;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class UserserviceApplication {
	
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private DiscoveryClient client;
	
	@GetMapping("/access")
	public String invokeGreeting() {
		URI service = client.getInstances("GREETING-SERVICE").stream().map(si -> si.getUri()).findFirst().map(s -> s.resolve("/greEting")).get();
		
		return template.getForObject(service, String.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
