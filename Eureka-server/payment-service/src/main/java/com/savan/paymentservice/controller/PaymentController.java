/**
 * 
 */
package com.savan.paymentservice.controller;

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
	
	@GetMapping("/paynow/{price}")
	public String payNow(@PathVariable int price) {
		return "Payment amount : "+price;
	}

}
