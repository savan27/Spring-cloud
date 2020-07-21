/**
 * 
 */
package com.savan.orderservice.dto;

import com.savan.orderservice.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author SAVAN
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransectionRequest {

	private Order order;
	private Payment payment;
	
}
