/**
 * 
 */
package com.savan.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.savan.orderservice.dto.TransectionRequest;
import com.savan.orderservice.dto.TransectionResponse;
import com.savan.orderservice.service.OrderService;

/**
 * @author SAVAN
 *
 */
@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@PostMapping("/bookOrder")
	public TransectionResponse bookOrder(@RequestBody TransectionRequest request) {
		return service.saveOrder(request);
	}

}
