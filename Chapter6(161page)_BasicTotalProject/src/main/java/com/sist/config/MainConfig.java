package com.sist.config;

import javax.inject.Qualifier;

import org.springframework.context.annotation.Configuration;
/*
 *   메모리 할당 (스프링에서 클래스를 관리) 
 *   -----------------------------
 *   구분 (클래스별로 구분) => 클래스위에 배치 
 *   1. @Component
 *      @Repository
 *      @Service
 *      @Controller
 *      @RestController
 *      @ControllerAdvice,@RestControllerAdvice
 *      @Configuration
 *   2. 주입 (DI) 
 *      => 메소드 위에 , 멤버변수 위 , 매개변수 옆에
 *      @Autowired ==> 자동 주입 (스프링에 의해서 자동으로 주소값을 주입)
 *      @Resource => 1.8지원 (특정 객체 찾기)
 *      @Qualifier => 특정 객체 찾기 
 *      @PostConstructor => method-di (init-method)
 *      @PreDestroy => method-di (destroy-method)
 *      
 */
@Configuration
//자바로 클래스를 스프링에 등록 
public class MainConfig {
  
}
