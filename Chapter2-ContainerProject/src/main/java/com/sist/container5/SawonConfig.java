package com.sist.container5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
// 스프링5 => 클래스 등록시에 XML을 사용하는 것이 아니라 순수하게 자바로만 사용 
// 보안 => XML(노출) => 자바는 컴파일된 파일만 제공(소스 노출이 없다)
// => 교재 스프링 5 
// 실무(유지보수 => 4) , 차세대 개발(5)
@Configuration
// 스프링 5 => 클래스 등록 파일 
public class SawonConfig {
  /*
   *   <bean id="sa" class="com.sist.container.Sawon" scope="prototype"></bean>
   */
  @Bean("sa") // id 
  @Scope("prototype") // 여러개 사용이 가능 (메모리 주소가 동일) 
  // 생략을 하면 singleton이다 
  public Sawon sawon(){
	  return new Sawon(); // class
  }
}
