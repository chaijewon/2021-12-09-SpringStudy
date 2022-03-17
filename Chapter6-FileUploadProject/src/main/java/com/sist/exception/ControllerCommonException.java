package com.sist.exception;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
// 154page 
@ControllerAdvice("com.sist.web")
// Controller에서 발생하는 에러처리를 한번에 처리 (반드시 패키지 설정)
public class ControllerCommonException {
   /*
    *   예외처리 : 에러 처리 , 정상적인 수행이 가능하게 만들어 준다 
    *   1. RuntimeException(연산처리 , 배열 , Null , 형변환)
    *   2. SQLException (오라클 처리)
    *   3. IOException
    *   
    */
	// catch => try(평상시 문장)
	@ExceptionHandler(RuntimeException.class)
	public void runtimeExeptionHandler(RuntimeException ex)
	{
		System.out.println("=== RuntimeException발생 ===");
		System.out.println(ex.getMessage());
	}
	@ExceptionHandler(SQLException.class)
	public void sqlExceptionHandler(SQLException ex)
	{
		System.out.println("=== SQLException발생 ===");
		System.out.println(ex.getMessage());
	}
	@ExceptionHandler(IOException.class)
	public void ioExceptionHandler(IOException ex)
	{
		System.out.println("=== IOException발생 ===");
		System.out.println(ex.getMessage());
	}
	@ExceptionHandler(Exception.class)
	public void exceptionHandler(Exception ex)
	{
		System.out.println("=== Exception발생 ===");
		System.out.println(ex.getMessage());
	}
}








