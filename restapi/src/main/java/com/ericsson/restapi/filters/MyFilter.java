package com.ericsson.restapi.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyFilter implements Filter{
	
	Logger LOGGER = LoggerFactory.getLogger(MyFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		LOGGER.info("MyFilter - Inside doFilter Method");
		LOGGER.info("Local Port : " + request.getLocalPort());
		LOGGER.info("Local Port : " + request.getServerName());
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		LOGGER.info("Method Name :" + httpServletRequest.getMethod());
		LOGGER.info("Request URI :" + httpServletRequest.getRequestURI());
		LOGGER.info("Servlet Path :" + httpServletRequest.getServletPath());
		
		chain.doFilter(request, response);
	}

}
