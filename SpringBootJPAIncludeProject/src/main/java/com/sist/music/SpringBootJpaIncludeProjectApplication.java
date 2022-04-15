package com.sist.music;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sist.music.controller"})
public class SpringBootJpaIncludeProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaIncludeProjectApplication.class, args);
	}

}
