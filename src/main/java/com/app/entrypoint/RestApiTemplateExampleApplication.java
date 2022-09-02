package com.app.entrypoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan({"com.app.api","com.app.service","com.app.mapper","com.app.dao"})
@EnableJpaRepositories("com.app.dao")
@EntityScan("com.app.entity")
public class RestApiTemplateExampleApplication {


	
	public static void main(String[] args) {
		SpringApplication.run(RestApiTemplateExampleApplication.class, args);
	}

	
	@Bean 
	public RestTemplate restTemplate() {
		
		
		return new RestTemplate();
	}
}
