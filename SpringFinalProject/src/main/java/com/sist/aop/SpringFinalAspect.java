package com.sist.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// 재사용기법 (메소드 자동 호출) => 반복을 제거하는 프로그램 (AOP)
// 오버로딩(new) / 오버라이딩(modify) 
/*
 *    JoinPoint 
 *      @Before
 *      @After
 *      @AfterReturning
 *      @AfterThrowing
 *      @Around 
 *      ------------------- 로그 , 트랜잭션 (일괄처리) , 보안 (인가,인증)
 *    PointCut 
 *      * 패키지명.클래스명.*(..) => 매개변수 (0이상)
 *     ===              --
 *     return형                  모든 메소드 
 *    -------------- Advice 
 *    --------------------- Aspect
 */
@Aspect // 메모리 할당을 하지 않는다 
@Component // 로그(사용자가 요청 => 처리)
public class SpringFinalAspect {
   @Around("execution(* com.sist.web.*Controller.*(..))")
   public Object around(ProceedingJoinPoint jp) throws Throwable
   {
	   Object obj=null;
	   System.out.println(jp.getSignature()+"호출전...");
	   long start=System.currentTimeMillis();
	   obj=jp.proceed();
	   long end=System.currentTimeMillis();
	   System.out.println(jp.getSignature()+"메소드 처리 시간:"+(end-start));
	   return obj;
   }
   
}









