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
public class TransectionResponse {
	
	private Order order;
	private double amount;
	private String transectionId;
	private String message;

}
