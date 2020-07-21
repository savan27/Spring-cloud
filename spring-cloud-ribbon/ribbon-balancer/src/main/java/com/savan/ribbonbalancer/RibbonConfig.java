package com.savan.ribbonbalancer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;

@Configuration
public class RibbonConfig {
	
	@Autowired
	IClientConfig config;
	
	@Bean
	public IPing getPing(IClientConfig config) {
		return new PingUrl();
	}
	
	@Bean
	public IRule getRul(IClientConfig config) {
		return new AvailabilityFilteringRule();
	}

}
