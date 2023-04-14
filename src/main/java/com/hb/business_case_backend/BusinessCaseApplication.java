package com.hb.business_case_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.hb.business_case_backend.repository")
@EntityScan(basePackages = "com.hb.business_case_backend.entity")
public class BusinessCaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessCaseApplication.class, args);
	}
}
