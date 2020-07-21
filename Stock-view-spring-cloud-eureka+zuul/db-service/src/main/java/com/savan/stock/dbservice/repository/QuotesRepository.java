/**
 * 
 */
package com.savan.stock.dbservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.savan.stock.dbservice.model.Quote;

/**
 * @author SAVAN
 *
 */
public interface QuotesRepository extends JpaRepository<Quote, Integer> {

	List<Quote> findByuserName(String username);

}
