/**
 * 
 */
package com.savan.HospitalGateWay.filter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * @author SAVAN
 *
 */
@Component
public class ErrorFilter extends ZuulFilter {
	
	private final static Logger logger = LoggerFactory.getLogger(ErrorFilter.class);

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {

		HttpServletResponse response = RequestContext.getCurrentContext().getResponse();
		
		logger.info("errorFilter: "+String.format("responce content type is %s", response.getStatus()));
		
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "error";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
