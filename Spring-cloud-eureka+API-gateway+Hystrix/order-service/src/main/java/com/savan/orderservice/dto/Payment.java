/**
 * 
 */
package com.savan.orderservice.dto;

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
public class Payment {
	
	private int paymentId;
	private String paymentStatus;
	private String transectionId;
	private int orderId;
	private double amount;

}
