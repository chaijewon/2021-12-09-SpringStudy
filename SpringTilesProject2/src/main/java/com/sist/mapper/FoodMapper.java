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
}
