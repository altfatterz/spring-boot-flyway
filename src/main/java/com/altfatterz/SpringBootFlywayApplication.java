package com.altfatterz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

/**
 * Available profiles --spring.profiles.active=h2 or --spring.profiles.active=postgresql
 *
 * http --pretty=colors --verbose :8080/v1/athletes
 */
public class SpringBootFlywayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFlywayApplication.class, args);
	}
}
