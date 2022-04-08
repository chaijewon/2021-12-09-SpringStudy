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
  
  // Recipe - Find
  @Select("SELECT no,title,poster,num "
	     +"FROM (SELECT no,title,poster,rownum as num "
		 +"FROM (SELECT /*+ INDEX_ASC(recipe recipe_no_pk)*/ no,title,poster "
		 +"FROM recipe "
		 +"WHERE title LIKE '%'||#{fd}||'%')) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<RecipeVO> recipeFindData(Map map);
  
  @Select("SELECT CEIL(COUNT(*)/12.0) "
		 +"FROM recipe "
		 +"WHERE title LIKE '%'||#{fd}||'%'")
  public int recipeFindTotalPage(String fd);
  
  // 추천 = 레시피 
  @Select("SELECT no,title,poster,num "
		 +"FROM (SELECT no,title,poster,rownum as num "
		 +"FROM (SELECT /*+ INDEX_ASC(recipe recipe_no_pk)*/no,title,poster "
		 +"FROM recipe "
		 +"WHERE REGEXP_LIKE(title,#{fd}))) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  // 밥/죽/떡 => Like 3번  => REGEXP_LIKE(title,'밥|죽|떡')
  public List<RecipeVO> recipeRecommandData(Map map);
  
  @Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe "
		 +"WHERE REGEXP_LIKE(title,#{fd})")
  public int recipeRecommandTotalPage(String fd);
  
  // main
  @Select("SELECT no,title,poster "
		 +"FROM recipe "
		 +"WHERE no=#{no}")
  public RecipeVO recipeMainData(int no);
  /*
   *    WHERE 
   *      title LIKE
   *      OR subject LIKE
   *      OR CHEF LIKE   ===> 접두어 , 접미어 
   *    where
   *    if(col==T)
   *      title LIKE ...
   *    if(col==S)
   *      subject LIKE...
   *    if(col==C)
   *      chef LIKE
   *      
   *      ==> title , subject 
   *      title LIKE OR subject LIKE
   *      
   *       subject LIKE...OR chef LIKE
   *       
   *       prefixOverrides =. 제거 
   *       prefix 추가
   *       
   *       <choose> 다중 조건 
   *         <when test="조건">SQL</when>
   *         <when test="조건">SQL</when>
   *         <when test="조건">SQL</when>
   *         <otherwise></otherwise>
   *       </choose>
   *       
   *       <if test="">SQL</if>
   *       <if test="">SQL</if>
   *       <if test="">SQL</if>
   *       <if test="">SQL</if>
   *       <if test="">SQL</if>  => else가 없다 
   *       
   *       prefixOverrides="OR|AND"
   *       suffixOverrides="OR|AND" => 제거
   *       
   *       prefix="OR"
   *       suffix=")"
   */
  @Select({"<script>"
	     +"SELECT no,title,poster,rownum "
		 +"FROM recipe "
	     +"WHERE "
		 +"<trim prefixOverrides=\"OR\">"
	     +"<foreach collection=\"fsArr\" item=\"fd\">"
		 +"<trim prefix=\"OR\">"
	     +"<choose>"
		 +"<when test=\"fd=='T'.toString()\">"
	     +"title LIKE '%'||#{ss}||'%'"
	     +"</when>"
	     +"<when test=\"fd=='C'.toString()\">"
	     +"chef LIKE '%'||#{ss}||'%'"
	     +"</when>"
	     +"</choose>"
	     +"</trim>"
	     +"</foreach>"
	     +"</trim>"
	     +"</script>"
  })
  public List<RecipeVO> recipeSearchData(Map map);
  
  @Select("SELECT product_name,product_poster,product_price "
		 +"FROM goods "
		 +"WHERE product_name LIKE '%'||#{product_name}||'%'")
  public List<GoodsVO> goodsLikeData(String product_name);
  
  @Select("SELECT COUNT(*) "
			 +"FROM goods "
			 +"WHERE product_name LIKE '%'||#{product_name}||'%'")
  public int goodsCountData(String product_name);
}










