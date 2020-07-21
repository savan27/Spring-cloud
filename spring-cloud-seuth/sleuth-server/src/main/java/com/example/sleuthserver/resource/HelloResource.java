/**
 * 
 */
package com.example.sleuthserver.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SAVAN
 *
 */
@RestController
@RequestMapping("/rest/hello")
public class HelloResource {
	
	private static final Logger log = LoggerFactory.getLogger(HelloResource.class);
	
	@GetMapping(value = "/server")
	public String hello() {
		log.info("Reached Server..");
		return "HelloWord";
	}

}
