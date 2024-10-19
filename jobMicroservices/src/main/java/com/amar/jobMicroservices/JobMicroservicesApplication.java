package com.amar.jobMicroservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class JobMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobMicroservicesApplication.class, args);
	}

}
