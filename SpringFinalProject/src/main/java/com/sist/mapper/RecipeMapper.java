package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface RecipeMapper {
  @Select("SELECT no,title,poster,num "
		 +"FROM (SELECT no,title,poster,rownum as num "
		 +"FROM (SELECT /*+ INDEX_ASC(recipe recipe_no_pk)*/ no,title,poster "
		 +"FROM recipe)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  // VO => #{no} => vo.getNo() , Map => #{no} => map.get("no")
  public List<RecipeVO> recipeListData(Map map);
  // public List<RecipeVO> recipeListData(int start,int end);(X)
  // 매개변수는 한개만 설정 
  // 총페이지 구하기 
  @Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe")
  public int recipeTotalPage();
  
  // 상세 보기 
  @Select("SELECT * FROM recipe_detail "
		 +"WHERE no=#{no}")
  public RecipeDetailVO recipeDetailData(int no); // recipe,chef => mapper => service
  // Chef 목록 출력 
  @Select("SELECT chef,poster,num "
		 +"FROM (SELECT chef,poster,rownum as num "
		 +"FROM (SELECT chef,poster "
		 +"FROM chef ORDER BY mem_cont1 DESC)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<ChefVO> chefListData(Map map);
  
  @Select("SELECT CEIL(COUNT(*)/12.0) FROM chef")
  public int chefTotalPage();
  
  // Chef가 만든 레시피 읽기
  @Select("SELECT no,poster,title,num "
		 +"FROM (SELECT no,poster,title,rownum as num "
		 +"FROM (SELECT /*+ INDEX_ASC(recipe recipe_no_pk)*/no,poster,title "
		 +"FROM recipe WHERE chef=#{chef})) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<RecipeVO> chefMakeRecipeData(Map map);
  // 총페이지 
  @Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe "
		 +"WHERE chef=#{chef}")
  public int chefMakeRecipeTotalpage(String chef);
}










