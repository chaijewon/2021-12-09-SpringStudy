package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
/*
 *   DML 
 *   @Select() : 데이터 검색 
 *   @SelectKey() : 자동 증가번호 => SEQUENCE가 만들어져 있는 경우에는 사용하지 않는다
 *   @Insert() : 데이터 추가 
 *   @Update() : 데이터 수정
 *   @Delete() : 데이터 삭제
 *   
 *   XML => <select id="" resultType="" parameterType="">
 *                 ------ ------------- ----------------
 *   Annotation => id=method명 , resultType=리턴형 parameterType=매개변수
 *   
 *   MyBatis 처리 
 *   1) 연결 (getConnection())
 *   2) PreparedStatement 자동 처리 => SQL을 전송 , 값을 받는다 
 *   3) ResultSet 자동 처리 
 *   4) conn.close() 자동 처리 
 *   --------------------------------------------------
 *   MyBatis => SQL문장 , 매개변수 처리 
 *   --------------------------------------------------
 *   XML / Annotation => 60/40 ==> JSP(ASPX) => Hibernate , C#(miplatform)
 *   => ?값을 첨부 
 *      #{일반 데이터} , ${컬럼명,테이블명}
 *        '홍길동'         ''=>없다
 */
public interface HotelMapper {
	@Select("SELECT no,name,poster,score,num "
		   +"FROM (SELECT no,name,poster,score,rownum as num "
		   +"FROM (SELECT /*+ INDEX_ASC(seoul_hotel sh_no_pk)*/ no,name,poster,score "
		   +"FROM seoul_hotel)) "
		   +"WHERE num BETWEEN #{start} AND #{end}")
	public List<HotelVO> hotelListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM seoul_hotel")
	public int hotelTotalPage();
	// 상세보기 => VO
	@Select("SELECT no,name,poster,score,images,address "
		   +"FROM seoul_hotel "
		   +"WHERE no=#{no}")
	public HotelVO hotelDetailData(int no);
}









