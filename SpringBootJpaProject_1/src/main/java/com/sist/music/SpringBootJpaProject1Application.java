package com.sist.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
// https://www.yna.co.kr/entertainment/movies
@SpringBootApplication
@ComponentScan(basePackages = {"com.sist.music.controller",
		"com.sist.music.dao","com.sist.music.entity"})
public class SpringBootJpaProject1Application {
    
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaProject1Application.class, args);
	    
	}

}
