package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface SeoulMapper {
   @Select("SELECT no,poster,title,num "
		  +"FROM (SELECT no,poster,title,rownum as num "
		  +"FROM (SELECT /*+ INDEX_ASC(seoul_location sl_no_pk)*/no,poster,title "
		  +"FROM seoul_location)) "
		  +"WHERE num BETWEEN #{start} AND #{end}")
   public List<SeoulVO> seoulLocationData(Map map);
   
   @Select("SELECT CEIL(COUNT(*)/12.0) FROM seoul_location")
   public int seoulLocationTotalPage();
   
   @Select("SELECT no,poster,title,num "
			  +"FROM (SELECT no,poster,title,rownum as num "
			  +"FROM (SELECT /*+ INDEX_ASC(seoul_nature sn_no_pk)*/no,poster,title "
			  +"FROM seoul_nature)) "
			  +"WHERE num BETWEEN #{start} AND #{end}")
   public List<SeoulVO> seoulNatureData(Map map);
	   
   @Select("SELECT CEIL(COUNT(*)/12.0) FROM seoul_nature")
   public int seoulNatureTotalPage();
   
   @Select("SELECT no,poster,name,num "
			  +"FROM (SELECT no,poster,name,rownum as num "
			  +"FROM (SELECT /*+ INDEX_ASC(seoul_hotel sh_no_pk)*/no,poster,name "
			  +"FROM seoul_hotel)) "
			  +"WHERE num BETWEEN #{start} AND #{end}")
   
  public List<SeoulVO> seoulHotelData(Map map);
		   
  @Select("SELECT CEIL(COUNT(*)/12.0) FROM seoul_hotel")
  public int seoulHotelTotalPage();
  
  // 상세보기 
  @Select("SELECT * FROM seoul_location "
		 +"WHERE no=#{no}")
  public SeoulVO seoulLocationDetailData(int no);
  
  @Select("SELECT * FROM seoul_nature "
			 +"WHERE no=#{no}")
  public SeoulVO seoulNatureDetailData(int no);
  
  @Select("SELECT * FROM seoul_hotel "
			 +"WHERE no=#{no}")
  public SeoulVO seoulHotelDetailData(int no);
  
  // 인근 맛집 
  @Select("SELECT no,poster,name,type,rownum "
		 +"FROM (SELECT no,poster,name,type "
		 +"FROM food_location "
		 +"WHERE address LIKE '%'||#{address}||'%') "
		 +"WHERE rownum<=8")
  public List<FoodVO> seoulLocationFoodHouse(String address);
  
  // 맛집에 관련된 레시피 
  @Select("SELECT no,poster,title "
		 +"FROM recipe "
		 +"WHERE REGEXP_LIKE(title,#{type})")
  public List<RecipeVO> seoulLocationRecipe(String type);
  
  // => 코스 만들기 
  // 1. 명소 
  @Select("SELECT no,title,rownum "
		 +"FROM (SELECT no,title "
		 +"FROM seoul_location "
		 +"WHERE address LIKE '%'||#{address}||'%' "
		 +"ORDER BY no ASC) "
		 +"WHERE rownum=1")
  public SeoulVO seoulMyLocationData(String address);
  // 2. 맛집 
  @Select("SELECT no,name,rownum "
		 +"FROM (SELECT no,name "
		 +"FROM food_location "
		 +"WHERE address LIKE '%'||#{address}||'%' "
		 +"ORDER BY no ASC) "
		 +"WHERE rownum=1")
  public FoodVO seoulMyFoodData1(String address);
  // 3. 자연 
  @Select("SELECT no,title,rownum "
			 +"FROM (SELECT no,title "
			 +"FROM seoul_nature "
			 +"WHERE address LIKE '%'||#{address}||'%' "
			 +"ORDER BY no ASC) "
			 +"WHERE rownum=1")
  public SeoulVO seoulMyNatureData(String address);
  // 4. 맛집 
  @Select("SELECT no,name,rownum "
			 +"FROM (SELECT no,name "
			 +"FROM food_location "
			 +"WHERE address LIKE '%'||#{address}||'%' "
			 +"ORDER BY no DESC) "
			 +"WHERE rownum=1")
  public FoodVO seoulMyFoodData2(String address);
}









