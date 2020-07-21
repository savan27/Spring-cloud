/**
 * 
 */
package com.savan.paymentservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SAVAN
 *
 */
@RequestMapping("/payment-provider")
@RestController
public class PaymentController {
	
	@Value("${server.port}")
	private String port;
	
	@GetMapping("/paynow/{price}")
	public String payNow(@PathVariable int price) {
		return "Payment amount : "+price+" and application is up on port : "+port;
	}

}
