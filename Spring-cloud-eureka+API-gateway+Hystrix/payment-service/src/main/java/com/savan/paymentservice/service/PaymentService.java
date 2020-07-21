/**
 * 
 */
package com.savan.paymentservice.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savan.paymentservice.entity.Payment;
import com.savan.paymentservice.repository.PaymentRepository;

/**
 * @author SAVAN
 *
 */
@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository repository;
	
	public Payment doPayment(Payment payment) {
		payment.setPaymentStatus(paymentProcessing());
		payment.setTransectionId(UUID.randomUUID().toString());
		return repository.save(payment);
	}

	public String paymentProcessing() {
		//api shoud be third party payment getway(paypal.paytm)
		return new Random().nextBoolean()?"success":"flase";
	}

	public Payment findPaymentHistoryByOrderId(int orderId) {
		return repository.findByorderId(orderId);
	}
}
