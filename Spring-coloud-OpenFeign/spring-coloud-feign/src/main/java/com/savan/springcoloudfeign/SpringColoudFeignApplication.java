package com.savan.springcoloudfeign;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.savan.springcoloudfeign.client.UserClient;
import com.savan.springcoloudfeign.dto.UserResponse;

@SpringBootApplication
@RestController
@EnableFeignClients
public class SpringColoudFeignApplication {
	
	@Autowired
	private UserClient client;
	
	@GetMapping("/findalluser")
	public List<UserResponse> getAllUsrs(){
		return client.getUsers();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringColoudFeignApplication.class, args);
	}

}
