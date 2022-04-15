package com.sist.music;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sist.music.controller",
		"com.sist.music.dao","com.sist.music.service"})
public class SpringBootMyBatisProject2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMyBatisProject2Application.class, args);
	}

}
