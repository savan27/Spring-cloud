/**
 * 
 */
package com.savan.cloudgateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

/**
 * @author SAVAN
 *
 */
@RestController
public class FallbackController {
	
	@RequestMapping("/orderFallBack")
	public Mono<String> orderServiceFallback(){
		return Mono.just("Order Service taking too long to response or is down, Please try again later");
	}
	
	@RequestMapping("/paymentFallBack")
	public Mono<String> paymentServiceFallback(){
		return Mono.just("Payment Service taking too long to response or is down, Please try again later");
	}

}
