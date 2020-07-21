/**
 * 
 */
package com.savan.paymentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.savan.paymentservice.entity.Payment;
import com.savan.paymentservice.service.PaymentService;

/**
 * @author SAVAN
 *
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService service;
	
	@PostMapping("/dopayment")
	public Payment doPayment(@RequestBody Payment payEntity) {
		return service.doPayment(payEntity);
	}
	
	@GetMapping("/{orderId}")
	public Payment findPaymentHistoryByOrderId(@PathVariable int orderId) {
		return service.findPaymentHistoryByOrderId(orderId);
	}
	

}
