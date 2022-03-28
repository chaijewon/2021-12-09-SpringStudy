package com.sist.mapper;
// SQL문장을 실행 => Mapper는 테이블당 한개씩 만든다 
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
/*
 *   오라클 
 *    SQL 
 *     = DML
 *        SELECT : 데이터 검색 
 *          => 내장 함수 (SUBSTR, RPAD , NVL , CEIL)
 *          => 연산자 (LIKE , IS NULL , IS NOT NULL , NOT,
 *             BETWEEN , IN)
 *          => JOIN / Subquery 
 *          => View(인라인뷰) 
 *        INSERT 
 *        UPDATE
 *        DELETE
 *     = DDL : table (제약조건) , view , sequence 
 *     = DCL : DBA 
 *     = TCL : COMMIT / ROLLBACK 
 *     
 *     웹 프로그래머 => DML / TCL
 *     = 간단한 table은 제작이 가능해야 된다 ..
 *     
 *   JSP : 지시자 (page,taglib) , 내장객체 (request,response, session,cookie)
 *         JSTL / EL / MVC
 *         
 *         
 *   Spring : DI , AOP , MVC , ORM (mybatis / jpa)
 *   
 *   Front : Jquery , Ajax , VueJS , ReactJS
 *   
 *   AWS : 클라우드 (배포)  => 운영체제를 빌려서 사용 (웹 호스팅)
 *  
 */
public interface FoodMapper {
   @Select("SELECT no,cno,poster,name,tel,type,address,score "
		  +"FROM food_house "
		  +"WHERE cno=#{cno}")
   public List<FoodVO> categoryFoodListData(int cno);
   // food_house , food_location
   /*
    *    name=#{name} => 홍길동 => '홍길동'
    *    name=${name} => 홍길동 => 홍길동 ===> 일반 데이터가 아니라 테이블명,컬럼명 
    *    
    *    FROM 'food_location' 
    */
   @Select("SELECT no,poster,name,tel,type,address,score,"
		  +"time,parking,menu "
		  +"FROM ${table_name} "
		  +"WHERE no=#{no}")
   public FoodVO foodDetailData(Map map);
   /*
    *    ORDER BY no DESC  INDEX_DESC()
    *    ORDER BY no ASC   INDEX_ASC()  => 274page
    *    UNIQUE / PK =>  자동으로 인덱스가 생성된다 
    */
   @Select("SELECT no,poster,name,num "
		  +"FROM (SELECT no,poster,name,rownum as num "
		  +"FROM (SELECT /*+ INDEX_ASC(food_location fl_no_pk)*/no,poster,name "
		  +"FROM food_location "
		  +"WHERE address LIKE '%'||#{address}||'%')) "
		  +"WHERE num BETWEEN #{start} AND #{end}")
   public List<FoodVO> foodFindData(Map map);
   
   
   
}










