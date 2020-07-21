/**
 * 
 */
package com.savan.clientcheckout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author SAVAN
 *
 */
@RestController
public class ClientController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/checkout/{price}")
	public String checkoutService(@PathVariable int price) {
		
		String url = "http://PAYMENT-SERVICE/payment-provider/paynow/"+price;

		return restTemplate.getForObject(url, String.class);
	}

}
