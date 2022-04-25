package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface FoodMapper {
  @Select("SELECT no,name,poster,score,num "
		 +"FROM (SELECT no,name,poster,score,rownum as num "
		 +"FROM (SELECT /*+ INDEX_ASC(food_location fl_no_pk)*/ no,name,poster,score "
		 +"FROM food_location)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<FoodVO> foodFindData(Map map);
  @Select("SELECT CEIL(COUNT(*)/12.0) FROM food_location")
  public int foodLocationTotalPage();
}
