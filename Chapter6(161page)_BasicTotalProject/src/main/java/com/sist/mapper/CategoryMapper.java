package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface CategoryMapper {
   @Select("SELECT cno,title,subject,poster "
		  +"FROM food_category "
		  +"ORDER BY 1")
   public List<CategoryVO> categoryAllData();
   
   @Select("SELECT title,subject FROM food_category "
		  +"WHERE cno=#{cno}")
   public CategoryVO categoryInfodata(int cno);
   
   @Select("SELECT no,name,poster,type,tel,address,score "
		  +"FROM food_house "
		  +"WHERE cno=#{cno}")
   public List<FoodVO> categoryFoodListData(int cno);
}
