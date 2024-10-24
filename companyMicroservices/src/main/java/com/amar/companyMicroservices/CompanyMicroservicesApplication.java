package com.amar.companyMicroservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CompanyMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyMicroservicesApplication.class, args);
	}

}
