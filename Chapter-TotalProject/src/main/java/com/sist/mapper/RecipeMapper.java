package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface RecipeMapper {
  //1. 레시피 목록 (페이징 기법) => Block별 처리  => 이전 / 다음 (사용하지 않는다)
  //인라인뷰 ,  rownum 
  @Select("SELECT no,poster,title,chef,num "
		 +"FROM (SELECT no,poster,title,chef,rownum as num "
		 +"FROM (SELECT /*+ INDEX_ASC(recipe recipe_no_pk) */ no,poster,title,chef "
		 +"FROM recipe)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<RecipeVO> recipeListData(Map map);
  // #{} => 한개 (일반데이터형)
  // #{} => 여러개 (~VO(getter) , Map(key))
  // {} => getXxx()호출 
  // ${} => 컬럼명,테이블명 
  // # => 문자열 ''
  // $ => 문자열 ''(X)
  // #{no} => getNo()
  //2. 총페이지 
  @Select("SELECT CEIL(COUNT(*)/20.0) FROM recipe")
  public int recipeTotalPage();
  //3. 레시피의 총갯수 
  @Select("SELECT COUNT(*) FROM recipe")
  public int recipeCount();
  
  //4. chef 
  //4-1. chef => 페이징
  @Select("SELECT poster,chef,mem_cont1,mem_cont2,mem_cont3,mem_cont7,num "
		 +"FROM (SELECT poster,chef,mem_cont1,mem_cont2,mem_cont3,mem_cont7,rownum as num "
		 +"FROM (SELECT poster,chef,mem_cont1,mem_cont2,mem_cont3,mem_cont7 "
		 +"FROM chef ORDER BY mem_cont3 DESC)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<ChefVO> chefListData(Map map);
  //4-2. 총페이지 
  @Select("SELECT CEIL(COUNT(*)/20.0) FROM chef")
  public int chefTotalPage();
  
  //4-3. 쉐프별로 제작된 레시피 출력 => 동적 쿼리 
  @Select("SELECT no,poster,chef,title,num "
		 +"FROM (SELECT no,poster,chef,title,rownum as num "
		 +"FROM (SELECT /*+ INDEX_ASC(recipe recipe_no_pk)*/ no,poster,chef,title "
		 +"FROM recipe "
		 +"WHERE chef LIKE '%'||#{chef}||'%')) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<RecipeVO> chefRecipeListDataAll(Map map);
  
  @Select("SELECT no,poster,chef,title,num "
			 +"FROM (SELECT no,poster,chef,title,rownum as num "
			 +"FROM (SELECT /*+ INDEX_ASC(recipe recipe_no_pk)*/ no,poster,chef,title "
			 +"FROM recipe "
			 +"WHERE chef LIKE '%'||#{chef}||'%' AND title LIKE '%'||#{ss}||'%')) "
			 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<RecipeVO> chefRecipeListData(Map map);
  
  @Select("SELECT CEIL(COUNT(*)/20.0) FROM recipe "
		 +"WHERE chef LIKE '%'||#{chef}||'%'")
  public int chefRecipeCountAll(String chef);
  
  @Select("SELECT CEIL(COUNT(*)/20.0) FROM recipe "
			 +"WHERE chef LIKE '%'||#{chef}||'%' AND title LIKE '%'||#{ss}||'%'")
  public int chefRecipeCount(Map map);
  
  // 상세보기 
  @Select("SELECT * FROM recipe_detail "
		 +"WHERE no=#{no}")
  public RecipeDetailVO recipeDetailData(int no);
}







