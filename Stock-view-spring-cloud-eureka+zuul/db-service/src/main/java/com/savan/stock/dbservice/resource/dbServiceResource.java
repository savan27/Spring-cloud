/**
 * 
 */
package com.savan.stock.dbservice.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.savan.stock.dbservice.model.Quote;
import com.savan.stock.dbservice.model.Quotes;
import com.savan.stock.dbservice.repository.QuotesRepository;

/**
 * @author SAVAN
 *
 */
@RestController
@RequestMapping("/rest/db")
public class dbServiceResource {
	
	@Autowired
	private QuotesRepository quotesRepository;
	
	@GetMapping("/{username}")
	public List<String> getQuots(@PathVariable("username") final String username){
		return getQuotesByUserName(username);
	}

	@PostMapping("/add")
	public List<String> add(@RequestBody final Quotes quotes){
		quotes.getQuotes()
			.stream()
			.map(quote -> new Quote(quotes.getUserName(),quote))
			.forEach(quote -> quotesRepository.save(quote));
		
		return getQuotesByUserName(quotes.getUserName());
	}
	
	@PostMapping("/delete/{username}")
	public List<String> delete(@PathVariable("username") final String username) {
		
		List<Quote> quotes = quotesRepository.findByuserName(username);
		quotesRepository.deleteAll(quotes);
		
		return getQuotesByUserName(username);
	}
	
	private List<String> getQuotesByUserName(final String username) {
		return quotesRepository.findByuserName(username)
				.stream()
				.map(Quote::getQuote)
				.collect(Collectors.toList());
	}
	
}
