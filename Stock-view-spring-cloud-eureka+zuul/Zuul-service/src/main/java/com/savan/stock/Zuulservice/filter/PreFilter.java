/**
 * 
 */
package com.savan.stock.Zuulservice.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;


/**
 * @author SAVAN
 *
 */
@Component
public class PreFilter extends ZuulFilter {
	
	private final static Logger logger = LoggerFactory.getLogger(PreFilter.class);


	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		logger.info("prefilter called");
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
