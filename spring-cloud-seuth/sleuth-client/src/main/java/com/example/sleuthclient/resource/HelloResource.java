/**
 * 
 */
package com.example.sleuthclient.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author SAVAN
 *
 */
@RestController
@RequestMapping("/rest/hello")
public class HelloResource {
	
	private static final Logger log = LoggerFactory.getLogger(HelloResource.class);
	
	@Autowired
	private RestTemplate template;
	
	@GetMapping(value = "/client")
	public String hello() {
		log.info("Before calling the server");
		String response = template.getForObject("http://localhost:8081/rest/hello/server", String.class);
		log.info("After calling the server");
		return response;
	}
	

}
