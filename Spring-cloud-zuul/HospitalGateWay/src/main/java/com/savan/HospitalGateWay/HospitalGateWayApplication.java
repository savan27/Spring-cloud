package com.savan.HospitalGateWay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class HospitalGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalGateWayApplication.class, args);
	}

}
