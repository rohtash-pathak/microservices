package com.ericsson.restapi.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="custom-beans")
public class CustomBeanEndPoint {
	
	   @Autowired
		private ApplicationContext applicationContext;
	   
		@ReadOperation
		public String[] getAllRegBeanNames()
		{
			
			return applicationContext.getBeanDefinitionNames();

	       
		}
	    
	
}
