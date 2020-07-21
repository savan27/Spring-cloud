package com.savan.greetingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GreetingserviceApplication {

	@GetMapping("/greEting")
	public String getMessage() {
		return "welcome..!!";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(GreetingserviceApplication.class, args);
	}

}
