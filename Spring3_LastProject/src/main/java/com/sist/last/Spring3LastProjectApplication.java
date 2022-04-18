package com.sist.last;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sist.last.controller"})
public class Spring3LastProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring3LastProjectApplication.class, args);
	}

}
