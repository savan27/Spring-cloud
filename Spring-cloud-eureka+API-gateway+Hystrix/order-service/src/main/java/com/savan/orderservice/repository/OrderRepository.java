/**
 * 
 */
package com.savan.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.savan.orderservice.entity.Order;

/**
 * @author SAVAN
 *
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
