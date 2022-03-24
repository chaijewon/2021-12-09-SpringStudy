package com.sist.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect2 {
  // @ControllerAdvice : 공통 예외처리 
  /*
   *   = Before
   *   = After
   *   = Around
   *   -------------- 로그 , 트랜잭션 , 보안 => 이미 만들어져 있다 
   *   -------------- 사용자 정의 Aspect는 거의 없다 
   *   -------------- 동작하는 과정 
   */
  @AfterThrowing(value="execution(* com.sist.dao.MyDAO2.*(..))",throwing = "ex")
  public void afterThrowing(Throwable ex)
  {
	  // try~catch가 없는 경우에 주로 사용 => RuntimeException 
	  System.out.println("---------에러발생------------");
	  System.out.println(ex.getMessage());
  }
}
