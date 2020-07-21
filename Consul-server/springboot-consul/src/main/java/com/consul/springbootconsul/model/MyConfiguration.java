/**
 * 
 */
package com.consul.springbootconsul.model;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * @author SAVAN
 *
 */
@ConfigurationProperties(prefix = "my")
@Data
public class MyConfiguration {
	
	private String username;
	private String password;

}
