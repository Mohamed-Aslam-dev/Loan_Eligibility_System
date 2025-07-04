package com.loan_eligibility_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com"})
@EntityScan(basePackages = {"com"})
@EnableJpaRepositories(basePackages = {"com"})
public class LoanEligibilitySystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanEligibilitySystemApplication.class, args);
		System.out.println("Testedok");
	}

}

