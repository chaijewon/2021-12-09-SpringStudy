package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
// @Autowired를 사용하려면 반드시 스프링에서 메모리를 할당한다 
/*
 *     @Component
 *     @Service
 *     @Repository
 *     @Controller
 *     @RestContoller
 *     @ControllerAdvice
 *     ====== 전체 패키지 등록시에 선택적인 메모리 할당 
 *     
 *     스프링 (객체의 생명주기 관리) 
 *           === 관리(사용자가 요청한 클래스만 관리)
 *     1. 등록된 모든 클래스의 메모리 할당 
 *     2. DI (값을 주입 , 객체주소값 주입)
 *     3. 메소드 호출 (init-method)
 *     -----------------------------
 *     4. 프로그래머가 활용하는 부분 
 *     -----------------------------
 *     5. 메소드 호출 (destroy-method)     객체와 객체의 의존 관계도설정 (DI)
 */
public class RecipeDAO {
   // 스프링으로부터 필요한 객체를 가지고 온다 
   @Autowired
   private RecipeMapper mapper;
   
   public List<RecipeVO> recipeListData(Map map)
   {
	   return mapper.recipeListData(map);
   }
   public int recipeTotalPage()
   {
	   return mapper.recipeTotalPage();
   }
   public RecipeDetailVO recipeDetailData(int no)
   {
	   return mapper.recipeDetailData(no);
   }
   
   public List<ChefVO> chefListData(Map map)
   {
	   return mapper.chefListData(map);
   }
   public int chefTotalPage()
   {
	   return mapper.chefTotalPage();
   }
   
   public List<RecipeVO> chefMakeRecipeData(Map map)
   {
	   return mapper.chefMakeRecipeData(map);
   }
   public int chefMakeRecipeTotalpage(String chef)
   {
	   return  mapper.chefMakeRecipeTotalpage(chef);
   }
}








