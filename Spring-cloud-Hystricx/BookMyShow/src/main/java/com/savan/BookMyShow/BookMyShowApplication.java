package com.savan.BookMyShow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@SpringBootApplication
@RestController
@EnableHystrix
@EnableHystrixDashboard
public class BookMyShowApplication {
	
	@Autowired
	private RestTemplate template;

	@HystrixCommand(groupKey = "savan",commandKey = "savan",fallbackMethod = "bookMyShowFallback")
	@GetMapping("/booknow")
	public String bookShow() {
		String emailserviceResponce = template.getForObject("http://localhost:8181/emailservice/send", String.class);
		String paymentserviceResponce = template.getForObject("http://localhost:8282/paymentservice/paynow", String.class);
		return emailserviceResponce+"\n"+paymentserviceResponce;
	}
	
	@GetMapping("/booknowwithout")
	public String booknowwithout() {
		String emailserviceResponce = template.getForObject("http://localhost:8181/emailservice/send", String.class);
		String paymentserviceResponce = template.getForObject("http://localhost:8282/paymentservice/paynow", String.class);
		return emailserviceResponce+"\n"+paymentserviceResponce;
	}

	public static void main(String[] args) {
		SpringApplication.run(BookMyShowApplication.class, args);
	}
	
	public String bookMyShowFallback() {
		return "Fallback Method Called...";	
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
