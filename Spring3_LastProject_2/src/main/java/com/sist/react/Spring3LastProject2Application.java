package com.sist.react;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sist.react.controller",
		       "com.sist.react.dao",
		       "com.sist.react.service"})
public class Spring3LastProject2Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring3LastProject2Application.class, args);
	}

}
