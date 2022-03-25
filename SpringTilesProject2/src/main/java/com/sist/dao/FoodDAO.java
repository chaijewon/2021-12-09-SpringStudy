package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.FoodVO;
/*
 *  @Select("SELECT no,score,name,poster,num "
		 +"FROM (SELECT no,score,name,poster,rownum as num "
		 +"FROM (SELECT  INDEX_ASC(food_location fl_no_pk)no,score,name,poster "
		 +"FROM food_location "
		 +"WHERE address LIKE '%'||#{address}||'%')) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<FoodVO> foodFindData(Map map);
  
  @Select("SELECT CEIL(COUNT(*)/12.0) FROM food_location "
		 +"WHERE address LIKE '%'||#{address}||'%'")
  public int foodFindTotalPage(String address);
 */
import com.sist.mapper.*;
// 스프링에서 OOP의 규칙이 없는 곳은 어디인가?
@Repository
public class FoodDAO {
  // 구현된 클래스의 주소를 읽어 온다 (스프링)
  @Autowired
  private FoodMapper mapper;
  public List<FoodVO> foodFindData(Map map)
  {
	  return mapper.foodFindData(map);
  }
  public int foodFindTotalPage(String address)
  {
	  return mapper.foodFindTotalPage(address);
  }
  
}









