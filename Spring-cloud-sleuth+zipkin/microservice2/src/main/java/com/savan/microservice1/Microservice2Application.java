package com.savan.microservice1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;

@SpringBootApplication
@RestController
public class Microservice2Application {
	
	private static final Logger log = LoggerFactory.getLogger(Microservice2Application.class);
	
	@Autowired
	private RestTemplate templet;
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}


	public static void main(String[] args) {
		SpringApplication.run(Microservice2Application.class, args);
	}
	
	@GetMapping(value = "/microservice2")
	public String method2() {
		log.info("Inside method2");
		String response = templet.getForObject("http://localhost:8082/microservice3", String.class);
		log.info("The response received by method2 is " + response);
		return response;
	}

}
