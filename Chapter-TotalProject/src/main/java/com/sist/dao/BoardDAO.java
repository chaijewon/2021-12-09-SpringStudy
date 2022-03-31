package com.sist.dao;
// 재사용 => VO,Mapper,DAO,Controller
//         VO, Manager , Controller  (Open API)
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.sist.mapper.BoardMapper;
import com.sist.vo.*;
/*
 *   스프링에서 하는 역할  => Ioc (제어역전)
 *   =============== DL , DI 
 *   DL => lookup => 등록된 클래스 찾기 
 *                   ===
 *                   1) package단위 등록 => 선택
 *                     =======================
 *                      @Component : open api , 일반 클래스 
 *                      @Repository : DAO
 *                      @Service : BI(DAO통합)
 *                      @Controller : Model (JSP이동 , JSP값 전송)
 *                      @RestController : Model(일반 데이터 전송)
 *                      @ControllerAdvice :통합 예외처리
 *                     ======================= 클래스 용도별로 구분 
 *                   2) bean  => @Bean
 *                   
 *                   => getBean("id") => id는 반드시 지정 (중복없이)
 *                      => default => 자동 ID설정 클래스명 (첫자만 소문자)
 *   DI => injection => 주입 (일반데이터,객체주소)
 *                   *** 1) setterDI setXxx() => p:name => setName()
 *                   2) constructorDI  => c:name 
 *                   3) methodDI => init-method() , destroy-method()
 *                                  생성시                       소멸시 
 *                   4) 자동 주입 => @Autowired 
 *                                @Qualifier => 특정객체 선택 
 *                                ----------- @Resource() : 많이 사용(1.8)
 *                      JDK에서 가장 호환이 좋은 버전 (1.8) 
 *                      1.9 => 오라클에서 만들었다  
 *   
 *   
 */
@Repository
public class BoardDAO {
   @Autowired
   private BoardMapper mapper;
   // 목록 => 얻어서 => JSP (DAO는 전송이 불가능) => Controller<=>DispatcherServlet
   public List<BoardVO> boardListData(Map map) //JSP로 전송이 안됨 
   {
	   return mapper.boardListData(map);
   }
   public int boardTotalPage()
   {
	   return mapper.boardTotalPage();
   }
   public void boardInsert(BoardVO vo)
   {
	   mapper.boardInsert(vo);
   }
   public BoardVO boardDetailData(int no)
   {
	   mapper.boardHitIncrement(no);
	   return mapper.boardDetailData(no);
   }
}










