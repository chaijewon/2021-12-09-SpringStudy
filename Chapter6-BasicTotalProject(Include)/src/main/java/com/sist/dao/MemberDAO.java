package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
// 스프링은 등록된 클래스에서만 사용이 가능 => 등록이 없는 클래스는 스프링에서 주입이 불가능 
@Repository // 스프링에서 메모리 할당 요청 (선택적 구분)
/*
 *   @Component : 일반 클래스 (크롤링 , JSoup , XML 파싱.., 데이터분석)
 *   @Repository : DAO
 *   @Controller : Model (요청 처리 => 결과값 전송) => 화면이동(파일명,.do)
 *   @RestController: Model(요청처리 => 결과값 전송) => 일반 문자열 , JSON
 *   @Service : DAO 통합 
 *   @ControllerAdvice : 예외처리 통합 => 스프링에서 메모리 할당 요청시 => 6개중에 한개가 올라가 있어야 
 *                         메모리 
 *   패키지 지정 
 *   --------
 *     <context-component-scan base-package="com.sist.*">
 *     => 어노테이션이 없는 클래스는 continue;(제외)
 */
public class MemberDAO {
  @Autowired // 스프링에서 클래스가 메모리 할당 한 클래스안에서 사용이 가능 
  private MemberMapper mapper; // 구현된 클래스의 주소값을 설정 요청 
  /*
   *  // ID체크 (존재여부 확인)
  @Select("SELECT COUNT(*) FROM project_member "
		 +"WHERE id=#{id}")
  public int idCount(String id);
  // Password체크
  @Select("SELECT pwd FROM project_member "
		 +"WHERE id=#{id}")
  public String getPassword(String id);
  // name을 읽기 
  @Select("SELECT name FROM project_member "
		 +"WHERE id=#{id}")
  public String memberGetName(String id);
   */
  public int idCount(String id)
  {
	  return mapper.idCount(id);
  }
  public String getPassword(String id)
  {
	 return mapper.getPassword(id);  
  }
  public String memberGetName(String id)
  {
	  return mapper.memberGetName(id);
  }
}
