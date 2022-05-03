package com.ericsson.restapi.configurations;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ericsson.restapi.filters.MyFilter;

@Configuration
public class GetCoursesFilter {
	
	@Bean
	public FilterRegistrationBean<MyFilter> registrationBean(){
		FilterRegistrationBean<MyFilter> registrationBean = new FilterRegistrationBean<MyFilter>();
		registrationBean.setFilter(new MyFilter());
		registrationBean.addUrlPatterns("/courses/v1.0");
		return registrationBean;
		
		
	}

}
