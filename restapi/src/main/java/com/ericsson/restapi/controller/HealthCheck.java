package com.ericsson.restapi.controller;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component("myHealthCheck")	
public class HealthCheck implements HealthIndicator{

	
	@Override
	public Health health() {
		int errorCode=check();
		if (errorCode!=0) {
		return Health.down().withDetail("DB Service is down",errorCode).build();
		}
		else {
		return Health.up().build();
		}
	}
		

	public int check() {
		// Our logic to check health
		return 0;
	}
	

}
