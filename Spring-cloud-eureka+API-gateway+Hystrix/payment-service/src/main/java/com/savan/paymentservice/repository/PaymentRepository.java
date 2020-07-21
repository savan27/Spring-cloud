/**
 * 
 */
package com.savan.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.savan.paymentservice.entity.Payment;

/**
 * @author SAVAN
 *
 */
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{

	Payment findByorderId(int orderId);
}
