/**
 * 
 */
package com.savan.orderservice.service;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.savan.orderservice.dto.Payment;
import com.savan.orderservice.dto.TransectionRequest;
import com.savan.orderservice.dto.TransectionResponse;
import com.savan.orderservice.entity.Order;
import com.savan.orderservice.repository.OrderRepository;

/**
 * @author SAVAN
 *
 */
@Service
@RefreshScope
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	@Lazy
	private RestTemplate template;
	
	@Value("${microservice.payment-service.endpoints.endpoint.url}")
	private String endpointUrl;
	
	public TransectionResponse saveOrder(TransectionRequest	request) {
		String response="";
		Order order = request.getOrder();
		Payment payment = request.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		
		Payment paymentResponse = template.postForObject(endpointUrl, payment, Payment.class);
		
		response = paymentResponse.getPaymentStatus().equals("success")?"Payment order success":"payment failed";
			
		
		repository.save(order);
		
		return new TransectionResponse(order,paymentResponse.getAmount(),paymentResponse.getTransectionId(),response);
		
	}

}
