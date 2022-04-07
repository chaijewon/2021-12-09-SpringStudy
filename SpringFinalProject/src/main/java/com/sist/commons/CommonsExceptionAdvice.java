package com.sist.commons;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// Controller에서 발생하는 모든 예외처리를 공통으로 사용 
@ControllerAdvice("com.sist.web")  // 메모리할당이 가능 
// 스프링에서 관리 : ~Controller , ~DAO , ~Advice , ~Aspect , ~Manager(open api)
// 프로그래머 관리 : ~VO , ~DTO(일반 데이터형 취급) , interface(Mapper)
public class CommonsExceptionAdvice {
   @ExceptionHandler(SQLException.class)
   public void sqlException(SQLException ex)
   {
	   System.out.println("=== SQL 예외 발생 ===");
	   System.out.println(ex.getMessage());
	   System.out.println("=== 예외처리 완료 ===");
   }
   @ExceptionHandler(RuntimeException.class)
   public void runtimeException(RuntimeException ex)
   {
	   System.out.println("=== Runtime 예외 발생 ===");
	   System.out.println(ex.getMessage());
	   System.out.println("=== 예외처리 완료 ===");
   }
   @ExceptionHandler(IOException.class)
   public void ioException(IOException ex)
   {
	   System.out.println("=== IO 예외 발생 ===");
	   System.out.println(ex.getMessage());
	   System.out.println("=== 예외처리 완료 ===");
   }
   @ExceptionHandler(Exception.class)
   public void exception(Exception ex)
   {
	   System.out.println("=== 기타 예외 발생 ===");
	   System.out.println(ex.getMessage());
	   System.out.println("=== 예외처리 완료 ===");
   }
}
