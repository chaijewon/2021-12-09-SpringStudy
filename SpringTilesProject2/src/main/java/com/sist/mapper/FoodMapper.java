package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.FoodVO;
public interface FoodMapper {
  @Select("SELECT no,score,name,poster,num "
		 +"FROM (SELECT no,score,name,poster,rownum as num "
		 +"FROM (SELECT /*+ INDEX_ASC(food_location fl_no_pk)*/no,score,name,poster "
		 +"FROM food_location "
		 +"WHERE address LIKE '%'||#{address}||'%')) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<FoodVO> foodFindData(Map map);
  
  @Select("SELECT CEIL(COUNT(*)/12.0) FROM food_location "
		 +"WHERE address LIKE '%'||#{address}||'%'")
  public int foodFindTotalPage(String address);
  
  // 화면 이동 => 스프링 , 출력 => JSON , 화면 제어 :vueJS
  // VueJS ==> router , 스프링은 데이터만 전송 (스프링)
  // Spring-Boot (서버) => JPA (MySQL) , React=>웹스톰 , vscode
  // 상세보기 
  @Select("SELECT no,name,address,tel,score,type,"
		 +"poster,time,parking,menu "
		 +"FROM food_location "
		 +"WHERE no=#{no}")
  public FoodVO foodDetailData(int no);
  // JPA => findByNo(int no)
}
