package com.sist.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sist.controller"})
public class WebFrontServerProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebFrontServerProjectApplication.class, args);
	}

}
