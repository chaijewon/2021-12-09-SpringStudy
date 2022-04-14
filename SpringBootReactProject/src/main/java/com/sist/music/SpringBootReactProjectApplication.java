package com.sist.music;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sist.music.controller",
		"com.sist.music.entity","com.sist.music.dao"})
public class SpringBootReactProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootReactProjectApplication.class, args);
	}

}
