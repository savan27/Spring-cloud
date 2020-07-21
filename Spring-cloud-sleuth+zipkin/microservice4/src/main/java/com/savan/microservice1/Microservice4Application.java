package com.savan.microservice1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import brave.sampler.Sampler;

@SpringBootApplication
@RestController
public class Microservice4Application {
	
	private static final Logger log = LoggerFactory.getLogger(Microservice4Application.class);
	
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}


	public static void main(String[] args) {
		SpringApplication.run(Microservice4Application.class, args);
	}
	
	@GetMapping(value = "/microservice4")
	public String method4() {
		log.info("Inside method4");
		return "Hello World from microservice4";
	}

}
