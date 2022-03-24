package com.sist.web;
// AOP = 횡단지향적 프로그램 (공통모듈을 모아서 필요시마다 자동호출이 가능하게 만든다 
// AOP = 트랜잭션 , 로그 , 보안 => 이미 만들어져 있다 
/*
 *   기본 용어 
 *   Aspect 
 *   Advice 
 *   -------------
 *   JoinPoint : 호출 시점 
 *     before 
 *     after 
 *     after-throwing 
 *     after-retuning
 *     around
 *   Pointcut  : 어떤 메소드 
 *   ------------- Advice (Advice여러개 => Aspect)
 *   1. 메소드 제작 
 *   public String display()
 *   {
 *      @Before => 연결 (getConnection())
 *      try
 *      {
 *         @Around => 수행시간 
 *         실행문장
 *         @Around 
 *      }catch(Exception ex)
 *      {
 *          @AfterThrowing => catch절을 수행시에 
 *      }finally
 *      {
 *          @After => disConnection()
 *      }
 *      
 *       return ""; @AfterReturning => 정행 수행이 되었는지 확인 
 *   }
 *   
 *   2. 트랜잭션 
 *   public void insert()
 *   {
 *      try
 *      {
 *         @Around ==> conn.setAutoCommit(false); => true 
 *         insert();
 *         insert();
 *         insert();
 *         @Around ==> conn.commit() => insert()가 전체 정상수행이면 commit()
 *      }catch(Exception ex)
 *      {
 *         @AfterThrowing => conn.rollback() => insert중에 1개가 실패가 전체취소 
 *      }
 *      finally
 *      {
 *         @After ==> conn.setAutoCommit(true)
 *      } 
 *   }
 *   @Transactional
 *   public void insert()
 *   {
 *   }
 *   
 *   프로그램 => 두가지 형태 
 *   = 1. 공통으로 사용되는 소스 (공통 모듈=>관심사)
 *   = 2. 메소드마다 따로 사용되는 소스 (핵심 모듈 => 관심사)
 */
public class MyDAO {
  // => 모든 메소드에서 공통으로 사용되는 부분 => AOP
  // 오라클 연결 
  public void getConnection()
  {
	  System.out.println("오라클 연결!!!");
  }
  // 오라클 해제 
  public void disConnection()
  {
	  System.out.println("오라클 해제!!!");
  }
  // 데이터 읽기 
  public void select()
  {
	  getConnection();
	  System.out.println("오라클로부터 데이터 읽기...");
	  disConnection();
  }
  // 데이터 추가 
  public void insert()
  {
	  getConnection();
	  System.out.println("오라클에 데이터 추가...");
	  disConnection();
  }
  // AOP ==> Intercepter => 소스가 간결화 
  // 데이터 수정 
  public void update()
  {
	  getConnection();
	  System.out.println("오라클 데이터 수정...");
	  disConnection();
  }
  // 데이터 삭제
  public void delete()
  {
	  getConnection();
	  System.out.println("오라클 데이터 삭제...");
	  disConnection();
  }
  // 데이터 찾기 
  public void find()
  {
	  getConnection();
	  System.out.println("오라클에서 데이터 찾기...");
	  disConnection();
  }
}










