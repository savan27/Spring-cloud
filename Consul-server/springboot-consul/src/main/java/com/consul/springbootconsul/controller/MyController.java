/**
 * 
 */
package com.consul.springbootconsul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consul.springbootconsul.model.MyConfiguration;

/**
 * @author SAVAN
 *
 */
@EnableConfigurationProperties(value = MyConfiguration.class)
@RestController
public class MyController {
	
	@Autowired
	private MyConfiguration config;
	
	@GetMapping("/getconfogData")
	public MyConfiguration getCongConfiguration() {
		return config;
	}

}
