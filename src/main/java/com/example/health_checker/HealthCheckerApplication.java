package com.example.health_checker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class HealthCheckerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthCheckerApplication.class, args);
	}

}
