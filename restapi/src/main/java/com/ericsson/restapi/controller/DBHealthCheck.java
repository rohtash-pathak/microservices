package com.ericsson.restapi.controller;



import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component("myDBHealthCheck")	
@Slf4j
public class DBHealthCheck implements HealthIndicator {
	
	private DataSourceBuilder  dataSourceBuilder;
	
	@Value("${spring.datasource.url}")
	private String dbUrl;
	@Value("${spring.datasource.driver-class-name}")
	private String driver;
	@Value("${spring.datasource.username}")
    private String userName;     
	@Value("${spring.datasource.password}")
    private String password; 
	
	@Bean
	//creating db connection
    public DataSource getDataSource()
    {
    	log.info("Entering Given Env.....");
    	dataSourceBuilder=DataSourceBuilder.create();
    	dataSourceBuilder.url(dbUrl);
    	dataSourceBuilder.username(userName);
    	dataSourceBuilder.password(password);
    	dataSourceBuilder.driverClassName(driver);
    	return dataSourceBuilder.build();
   	
    }

	@Override
	public Health health() {
		Health health = null;
		
		try {
			if(getDataSource().getConnection() !=null) 
				health=Health.up().withDetail("status", "Database is UP").build();
			else
				health= Health.down().withDetail("status", "Database is DOWN").build();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return health;
	}

}
