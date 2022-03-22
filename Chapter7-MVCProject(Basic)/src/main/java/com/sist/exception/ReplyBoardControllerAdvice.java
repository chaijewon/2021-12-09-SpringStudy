package com.sist.exception;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// Controller에서 발생하는 예외처리 (공통) => 155page 
@ControllerAdvice
public class ReplyBoardControllerAdvice {
  @ExceptionHandler(SQLException.class)
  public void sqlException(SQLException ex)
  {
	  System.out.println("=== SQLException 발생 ===");
	  System.out.println(ex.getMessage());
	  System.out.println("========================");
  }
  @ExceptionHandler(RuntimeException.class)
  public void runtimeException(RuntimeException ex)
  {
	  System.out.println("=== RuntimeException 발생 ===");
	  System.out.println(ex.getMessage());
	  System.out.println("========================");
  }
  @ExceptionHandler(IOException.class) // catch
  public void ioException(IOException ex)
  {
	  System.out.println("=== IOException 발생 ===");
	  System.out.println(ex.getMessage());
	  System.out.println("========================");
  }
  @ExceptionHandler(Exception.class) // catch
  public void exception(Exception ex)
  {
	  System.out.println("=== Exception 발생 ===");
	  System.out.println(ex.getMessage());
	  System.out.println("========================");
  }
}
