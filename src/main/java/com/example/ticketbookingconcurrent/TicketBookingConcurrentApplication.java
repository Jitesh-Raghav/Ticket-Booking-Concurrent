package com.example.ticketbookingconcurrent;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "com.example.ticketbookingconcurrent.Repositories")
@EntityScan(basePackages = "com.example.ticketbookingconcurrent.Entity") // If your entities are in a different package
public class TicketBookingConcurrentApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TicketBookingConcurrentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
