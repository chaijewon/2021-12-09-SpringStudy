package com.sist.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// 공통모듈 
@Aspect // 메모리 할당이 안된다 (알림 => 프로그램에서 공통으로 사용된 기능을 가지고 있다)
@Component
public class ReplyBoardAspect {
   @Around("execution(* com.sist.web.ReplyBoardController.*(..))")
   public Object around(ProceedingJoinPoint jp) 
   {
	   Object obj=null;
	   try
	   {
		   //로그 파일 
		   System.out.println("----------------------------");
		   System.out.println(jp.getSignature()+" 수행전...");
		   long start=System.currentTimeMillis();
		   obj=jp.proceed(); // 메소드가 실제 수행 
		   long end=System.currentTimeMillis();
		   System.out.println(jp.getSignature()+" 수행 완료...");
		   System.out.println("수행 시간 :"+(end-start));
		   System.out.println("----------------------------");
	   }catch(Throwable ex){}
	   
	   return obj;
   }
   @AfterReturning(value="execution(* com.sist.web.ReplyBoardController.*(..))"
		   ,returning = "obj")
   public void afterReturning(Object obj)
   {
	   System.out.println("사용자가 요청한 사이트 이동 :"+obj);
   }
}
