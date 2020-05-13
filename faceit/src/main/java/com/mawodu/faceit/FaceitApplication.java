package com.mawodu.faceit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FaceitApplication {

	public static void main(String[] args) {
		SpringApplication.run(FaceitApplication.class, args);
	}

	// The microservice will be part of a more complex architecture,
	// so consider for example that the Search microservice will need to be notified when a new user is added,
	// or that the Competition microservice will need to be notified when the user changes his nickname.
	// Think at how to implement a system that is scalable.

	// The application must be a “good citizen”:
	// Meaningful logs
	// Self-documented end points
	// Health checks
	// ...etc

}
