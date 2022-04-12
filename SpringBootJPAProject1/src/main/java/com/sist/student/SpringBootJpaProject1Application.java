package com.sist.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sist.student.controller",
		"com.sist.student.dao","com.sist.student.entity"})
public class SpringBootJpaProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaProject1Application.class, args);
	}

}
