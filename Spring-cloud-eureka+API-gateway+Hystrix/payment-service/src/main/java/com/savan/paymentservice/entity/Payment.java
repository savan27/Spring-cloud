/**
 * 
 */
package com.savan.paymentservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author SAVAN
 *
 */
@Entity
@Table(name = "payent_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int paymentId;
	private String paymentStatus;
	private String transectionId;
	private int orderId;
	private double amount;

}
