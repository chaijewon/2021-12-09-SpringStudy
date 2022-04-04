package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;
// 스프링안에서 메모리 할당을 해야 => 구현된 mapper의 주소를 얻어 온다 (자동 주입)
/*
 *   1. 스프링 동작 => index.jsp => main.do 
 *      1=> web.xml을 톰캣에 의햇 구동 
 *          --------
 *          메모리 할당 => DispatcherServlet 
 *      2. DispatcherServlet ==> application-*.xml을 읽어 온다 
 *      3. application.*.xml에 등록된 모든 클래스 => 메모리 할당 
 *         - 클래스 메모리 할당 (<bean...>)
 *         - annotation 처리 
 *      4. 메모리 할당된 객체에 주입 (DI)
 *         @Autowired , @Resource() ==> getBean("id명")
 *      ---------------------------------------- map에 저장 
 *      5. 사용자가 필요할때 객체를 스프링으로부터 얻어서 => 활용 
 *      ----------------------------------------
 *      6. 종료 요청 => 메모리에서 객체를 소멸 
 *   2. MVC동작 (웹에서 요청을 받은 경우 = request => request를 받는 프로그램은 2개(JSP,Servlet)
 *      요청 (main.do) => DispatcherServlet(Servlet)
 *                      ------------------
 *                        1. 요청 받기 (DispatcherServlet)
 *                        2. 스프링에 저장된 클래스 찾기 = HandlerMapping (요청 처리하는 클래스)
 *                               => 1) 데이터베이스 연결 => SQL문장 처리 => DAO
 *                                  2) 데이터베이스를 모아서 전송 : VO
 *                                  3) DAO , VO => JSP로 전송 : @Controller
 *                                     ------------ Model => 스프링(요청을 제어 => Controller)
 *                                                           struts(Action) 
 *                                  => 구분 (요청) => @RequestMapping,@GetMapping,@PostMapping
 *                        3. JSP를 찾아서 request를 전송 = ViewResolver (화면에 출력) => JSP
 *                        
 *                        ==> 동장에 대한 셋팅 => XML
 */
@Repository // DAO메모리 할당 요청 
// 오라클 만 연결 (mapper) => ORM (관계형데이터베이스 연결)
// ORM => 베이스(DBCP) => 종류 (업체 요구 => MyBatis , JPA=>SQL문장을 사용하지 않는다)
// MyBatis => 1, DML , 2. JOIN ,SubQuery , 3. 동적쿼리 , 4. PL/SQL 
// Spring => XML셋팅 ,어노테이션 사용법 , DI ,AOP , MVC , ORM 
// 자바 => 1. 변수,연산자,제어문 , 2. 객체지향(클래스) , 3. 예외처리 , 컬렉션 
//       IO(다운로드 ,업로드) 
// 오라클 : DML,TCL
// JSP : MVC (EL/JSTL) => 내장객체 , 지시자 (page,taglib)
public class FoodDAO {
    // 스프링에서 구현된 매퍼의 주소값을 얻어 온다
    @Autowired
	private FoodMapper mapper;
    
    public List<FoodVO> foodListData(Map map)
    {
    	return mapper.foodListData(map);
    }
    public int foodTotalPage()
    {
    	return mapper.foodTotalPage();
    }
    public FoodVO foodDetailData(int no)
    {
    	return mapper.foodDetailData(no);
    }
}
