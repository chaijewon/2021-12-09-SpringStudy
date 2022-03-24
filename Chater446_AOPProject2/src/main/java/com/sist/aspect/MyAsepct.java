package com.sist.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import java.util.*;
@Aspect
@Component
// 공통모듈  => @AfterReturning : 정상수행시 return값을 받아서 처리가 가능 
// @AfterThrowing : catch(수행시)
// @Around : 로그 (시간) => 어떤 메소드가 호출되는지 확인  
public class MyAsepct {
   @AfterReturning(value="execution(* com.sist.dao.MyDAO.*(..))"
		   ,returning = "obj")
   // 시점 (호출되는 시점=메소드 수행시)
   public void afterReturning(Object obj)
   {
	   System.out.println("----------메소드 수행 결과-----------");
	   List<String> list=(List<String>)obj;
	   for(String s:list)
	   {
		   System.out.println(s);
	   }
   }
}
