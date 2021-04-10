package org.o7planing.springbooth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJpaH21Application {

	public static void main(String[] args) {
		System.out.println("BEFORE");
		SpringApplication.run(SpringBootJpaH21Application.class, args);
		System.out.println(" MAIN after run");
		
	}

}
